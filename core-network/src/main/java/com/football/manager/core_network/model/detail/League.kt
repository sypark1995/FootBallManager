package com.football.manager.core_network.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class League(
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "country")
    val country: String,
    @field:Json(name = "logo")
    val logo: String,
    @field:Json(name = "flag")
    val flag: String,
    @field:Json(name = "season")
    val season: Long,
    @field:Json(name = "standings")
    val standings: List<List<Standing>>,
)
