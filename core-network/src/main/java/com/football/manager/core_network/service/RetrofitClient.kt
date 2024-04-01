package com.football.manager.core_network.service

import com.google.gson.JsonElement
import javax.inject.Inject

class RetrofitClient @Inject constructor(
    private val retrofitService: RetrofitService
) {
    suspend fun getStandings(league: Int, season: Int): JsonElement =
        retrofitService.getStandings(
            league = league,
            season = season
        )
}
