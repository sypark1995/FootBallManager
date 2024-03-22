package com.football.manager.core_data.repository

import com.football.manager.core_network.adapter.onFailure
import com.football.manager.core_network.adapter.onSuccess
import com.football.manager.core_network.model.StandingResponse
import com.football.manager.core_network.service.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val retrofitClient: RetrofitClient
) : RankingRepository {
    override fun getStandings(
        league: Int,
        season: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        val response = retrofitClient.getStandings(league = league, season = season)
        response.onSuccess {
            emit(it)
        }
    }.onStart { onStart() }.onCompletion { onComplete() }


}