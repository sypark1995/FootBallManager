package com.football.manager.core_network.model.detail

import java.io.Serializable

data class Away(
    val played: Long,
    val win: Long,
    val draw: Long,
    val lose: Long,
    val goals: Goals,
): Serializable