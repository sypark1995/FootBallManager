package com.football.manager.core_network.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Goals(
    @field:Json(name = "for")
    val for_field: Long,

    @field:Json(name = "against")
    val against: Long,
)
