package com.football.manager.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.football.manager.core_data.ApiResult
import com.football.manager.core_data.repository.RankingRepository
import com.football.manager.core_data.successOrNull
import com.football.manager.core_network.model.detail.Standing
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val repository: RankingRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    /** after when 문 handling을 activity 까지 끌고 가서 핸들링 할 필요가 없음
     * */
    private val uiState: StateFlow<ApiResult<List<Standing>>> =
        repository.getStandings(11, 11).stateIn(
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

    /** before
     * */
//    private val _uiState = MutableStateFlow<ApiResult<List<Standing>>>(ApiResult.Loading)
//    val uiState = _uiState.asStateFlow()
//        fun getData(league: Int, season: Int) {
//        viewModelScope.launch {
//            repository.getStandings(league = league, season = season).collectLatest {
//                when (it) {
//                    is ApiResult.Success -> if (it.data.isNullOrEmpty()) {
//                        _uiState.emit(ApiResult.Success(emptyList()))
//                    } else {
//                        _uiState.emit(ApiResult.Success(it.data))
//                    }
//
//                    is ApiResult.Loading -> _uiState.emit(ApiResult.Loading)
//                    is ApiResult.Error -> _uiState.emit(ApiResult.Error(it.e))
//                }
//            }
//        }
//    }

}