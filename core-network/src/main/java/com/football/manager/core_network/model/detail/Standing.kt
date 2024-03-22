package com.football.manager.core_network.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Standing(
    @field:Json(name = "rank")
    val rank: Long,
    @field:Json(name = "team")
    val team: Team,
    @field:Json(name = "points")
    val points: Long,
    @field:Json(name = "goalsDiff")
    val goalsDiff: Long,
    @field:Json(name = "group")
    val group: String,
    @field:Json(name = "form")
    val form: String,
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "all")
    val all: All,
    @field:Json(name = "home")
    val home: Home,
    @field:Json(name = "away")
    val away: Away,
    @field:Json(name = "update")
    val update: String,
)

