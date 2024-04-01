package com.football.manager.core_network.model.detail

import java.io.Serializable

data class Team(
    val id: Long,
    val name: String,
    val logo: String,
): Serializable
