package com.football.manager.core_network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Base(
    @field:Json(name = "get")
    val get: String,
    @field:Json(name = "parameters")
    val parameters: Parameters,
    @field:Json(name = "errors")
    val errors: List<Any?>,
    @field:Json(name = "results")
    val results: Long,
    @field:Json(name = "paging")
    val paging: Paging,
    @field:Json(name = "response")
    val response: List<StandingResponse>,
)