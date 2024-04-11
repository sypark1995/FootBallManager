package com.football.manager.core_data.repository

import com.football.manager.core_data.ApiResult
import com.football.manager.core_data.AppDispatchers
import com.football.manager.core_data.Dispatcher
import com.football.manager.core_data.extension.getTimeNow
import com.football.manager.core_data.extension.getYearsNow
import com.football.manager.core_data.extension.stringToDate
import com.football.manager.core_data.safeFlow
import com.football.manager.core_data.toData
import com.football.manager.core_database.dao.TeamDao
import com.football.manager.core_database.mapper.asDomain
import com.football.manager.core_database.mapper.asEntity
import com.football.manager.core_network.model.BaseResponse
import com.football.manager.core_network.model.detail.Standing
import com.football.manager.core_network.service.RetrofitClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val retrofitClient: RetrofitClient,
    private val teamDao: TeamDao,
    @Dispatcher(AppDispatchers.IO) private val coroutineDispatcher: CoroutineDispatcher
) : RankingRepository {

    override fun getStandings(
        season: Long,
    ): Flow<ApiResult<List<Standing>>> = safeFlow {
        val data = teamDao.getTeamBySeasonList(season = season.toString())

        if (data.isEmpty()) {
            val response = retrofitClient.getStandings(season = season)
                .toData<BaseResponse>().response.first().league.standings

            response.forEach {
                teamDao.insertLeagueList(it.asEntity(season))
            }

            data.asDomain()
        } else {
            val yearsDiff = getYearsNow().toInt() - season.toInt()
            val localTime = data.first().update.stringToDate()

            if (yearsDiff == 0 || yearsDiff == 1) {
                val diffDays =
                    ((getTimeNow().stringToDate()!!.time - localTime!!.time) / 24 * 60 * 60)

                if (diffDays >= 1) {
                    val response = retrofitClient.getStandings(season = season)
                        .toData<BaseResponse>().response.first().league.standings

                    response.forEach {
                        teamDao.insertLeagueList(it.asEntity(season))
                    }
                    teamDao.getAllTeamList().asDomain()
                } else {
                    data.asDomain()
                }
            } else {
                data.asDomain()
            }

        }
    }.flowOn(coroutineDispatcher)
}