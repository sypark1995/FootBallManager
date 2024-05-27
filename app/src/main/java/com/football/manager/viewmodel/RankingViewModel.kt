package com.football.manager.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.football.manager.core_data.ApiResult
import com.football.manager.core_data.repository.RankingRepository
import com.football.manager.core_data.successOrNull
import com.football.manager.core_network.model.detail.Standing
import com.football.manager.view.util.ToggleCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    repository: RankingRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedButtonId = MutableStateFlow(ToggleCategory.Ranking)
    val selectedButtonId: StateFlow<ToggleCategory> get() = _selectedButtonId

    fun onButtonChecked(toggleCategory: ToggleCategory) {
        viewModelScope.launch {
            _selectedButtonId.value = toggleCategory
        }
    }

    val uiState: StateFlow<ApiResult<List<Standing>>> =
        repository.getStandings(2023).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = ApiResult.Loading
        )

    val standingList: StateFlow<List<Standing>> = uiState.map {
        it.successOrNull() ?: emptyList()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = emptyList()
    )
}