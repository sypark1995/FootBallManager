package com.football.manager.core_network.service

import com.football.manager.core_network.BuildConfig
import com.google.gson.JsonElement
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {
    @GET("standings")
    suspend fun getStandings(
        @Header("x-rapidapi-key") key: String = BuildConfig.API_KEY,
        @Query("league") league: Int = 39,
        @Query("season") season: Long,
    ): JsonElement
}
