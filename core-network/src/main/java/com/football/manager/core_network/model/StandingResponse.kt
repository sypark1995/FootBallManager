package com.football.manager.core_network.model

import com.football.manager.core_network.model.detail.League
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StandingResponse(
    @field:Json(name = "league")
    val league: League
)