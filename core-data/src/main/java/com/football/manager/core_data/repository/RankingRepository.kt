package com.football.manager.core_data.repository

import com.football.manager.core_data.ApiResult
import com.football.manager.core_network.model.detail.League
import com.football.manager.core_network.model.detail.Standing
import kotlinx.coroutines.flow.Flow

interface RankingRepository {

    fun getStandings(
        season: Long,
    ): Flow<ApiResult<List<Standing>>>
}