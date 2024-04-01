package com.football.manager.core_network.model

import com.football.manager.core_network.model.detail.League
import java.io.Serializable

data class StandingResponse(
    val league: League
): Serializable