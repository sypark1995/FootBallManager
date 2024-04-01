package com.football.manager.core_network.model.detail

import java.io.Serializable

data class League(
    val id: Long,
    val name: String,
    val country: String,
    val logo: String,
    val flag: String,
    val season: Long,
    val standings: List<List<Standing>>,
): Serializable
