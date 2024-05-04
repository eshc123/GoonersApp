package com.eshc.goonersapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.usecase.match.GetRecentlyMatchUseCase
import com.eshc.goonersapp.core.domain.usecase.match.GetUpcomingMatchesUseCase
import com.eshc.goonersapp.feature.home.state.RecentlyResultUiState
import com.eshc.goonersapp.feature.home.state.UpcomingMatchesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getUpcomingMatchesUseCase: GetUpcomingMatchesUseCase,
    getRecentlyMatchUseCase: GetRecentlyMatchUseCase
) : ViewModel() {
    val upcomingMatchesUiStateFlow: StateFlow<UpcomingMatchesUiState> =
        getUpcomingMatchesUseCase()
            .catch { exception ->
                UpcomingMatchesUiState.Error(exception.message)
            }.map { result ->
                when (result) {
                    is DataResult.Success -> { UpcomingMatchesUiState.Success(result.data) }
                    is DataResult.Failure -> { UpcomingMatchesUiState.Failed(result.message) }
                }
            }.stateIn(
                scope = viewModelScope,
                initialValue = UpcomingMatchesUiState.Loading,
                started = SharingStarted.Eagerly
            )

    val recentlyResultUiStateFlow: StateFlow<RecentlyResultUiState> =
        getRecentlyMatchUseCase()
            .catch { exception ->
                RecentlyResultUiState.Error(exception.message)
            }.map { result ->
                when (result) {
                    is DataResult.Success -> { RecentlyResultUiState.Success(result.data) }
                    is DataResult.Failure -> { RecentlyResultUiState.Failed(result.message) }
                }
            }.stateIn(
                scope = viewModelScope,
                initialValue = RecentlyResultUiState.Loading,
                started = SharingStarted.Eagerly
            )
}