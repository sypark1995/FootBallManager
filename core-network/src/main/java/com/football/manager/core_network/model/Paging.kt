package com.football.manager.core_network.model

import java.io.Serializable

data class Paging(
    val current: Long,
    val total: Long,
): Serializable