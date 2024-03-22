package com.football.manager.core_network.service

import com.football.manager.core_network.adapter.ApiResult
import com.football.manager.core_network.model.StandingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("standings")
    suspend fun getStandings(
        @Query("league") league: Int,
        @Query("season") season: Int,
    ): ApiResult<StandingResponse>
}
