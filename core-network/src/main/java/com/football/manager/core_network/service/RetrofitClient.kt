package com.football.manager.core_network.service

import com.football.manager.core_network.adapter.ApiResult
import com.football.manager.core_network.model.StandingResponse
import javax.inject.Inject

class RetrofitClient @Inject constructor(
    private val retrofitService: RetrofitService
) {
    suspend fun getStandings(league: Int, season: Int): ApiResult<StandingResponse> =
        retrofitService.getStandings(
            league = league,
            season = season
        )
}
