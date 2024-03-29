package com.football.manager.core_network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Paging(
    @field:Json(name = "current")
    val current: Long,
    @field:Json(name = "total")
    val total: Long,
)