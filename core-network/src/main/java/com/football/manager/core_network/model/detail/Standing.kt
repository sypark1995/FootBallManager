package com.football.manager.core_network.model.detail

import java.io.Serializable

data class Standing(
    val rank: Long,
    val team: Team,
    val points: Long,
    val goalsDiff: Long,
    val group: String,
    val form: String,
    val status: String,
    val description: String?,
    val all: All,
    val home: Home,
    val away: Away,
    val update: String
): Serializable

