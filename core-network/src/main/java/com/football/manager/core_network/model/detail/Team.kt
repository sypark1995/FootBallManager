package com.football.manager.core_network.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Team(
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "logo")
    val logo: String,
)
