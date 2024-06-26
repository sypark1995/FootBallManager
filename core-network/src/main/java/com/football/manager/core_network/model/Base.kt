package com.football.manager.core_network.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BaseResponse(
    @SerializedName("response")
    val response: List<StandingResponse>
): Serializable