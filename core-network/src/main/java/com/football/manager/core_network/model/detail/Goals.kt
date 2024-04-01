package com.football.manager.core_network.model.detail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Goals(
    @SerializedName("for")
    val for_field: Long,

    val against: Long,
): Serializable
