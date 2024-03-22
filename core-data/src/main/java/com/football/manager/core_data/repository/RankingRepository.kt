package com.football.manager.core_data.repository

import com.football.manager.core_network.model.StandingResponse
import kotlinx.coroutines.flow.Flow

interface RankingRepository {

    fun getStandings(
        league: Int, season: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit,
    ): Flow<StandingResponse>
}