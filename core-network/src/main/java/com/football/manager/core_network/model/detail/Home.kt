package com.football.manager.core_network.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Home(
    @field:Json(name = "played")
    val played: Long,
    @field:Json(name = "win")
    val win: Long,
    @field:Json(name = "draw")
    val draw: Long,
    @field:Json(name = "lose")
    val lose: Long,
    @field:Json(name = "goals")
    val goals: Goals,
)