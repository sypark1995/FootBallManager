package com.football.manager.core_data.repository

import com.football.manager.core_data.ApiResult
import com.football.manager.core_data.AppDispatchers
import com.football.manager.core_data.Dispatcher
import com.football.manager.core_data.safeFlow
import com.football.manager.core_network.model.StandingResponse
import com.football.manager.core_network.service.RetrofitClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val retrofitClient: RetrofitClient,
    @Dispatcher(AppDispatchers.IO) private val coroutineDispatcher: CoroutineDispatcher
) : RankingRepository {

    override fun getStandings(
        league: Int,
        season: Int,
    ): Flow<ApiResult<StandingResponse>> = safeFlow {
        retrofitClient.getStandings(league = league, season = season)
    }.flowOn(coroutineDispatcher)
}