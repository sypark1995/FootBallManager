package com.football.manager.core_network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Parameters(
    @field:Json(name = "league")
    val league: String,
    @field:Json(name = "season")
    val season: String,
)