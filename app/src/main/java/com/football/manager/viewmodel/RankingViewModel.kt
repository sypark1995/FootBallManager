package com.football.manager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.football.manager.core_data.ApiResult
import com.football.manager.core_data.repository.RankingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val repository: RankingRepository
) : ViewModel() {

    fun getData(league: Int, season: Int) {
        viewModelScope.launch {
            repository.getStandings(league = league, season = season).collectLatest {
                when (it) {
                    is ApiResult.Success -> {

                    }

                    is ApiResult.Loading -> {

                    }

                    is ApiResult.Error -> {

                    }
                }
            }
        }
    }
}