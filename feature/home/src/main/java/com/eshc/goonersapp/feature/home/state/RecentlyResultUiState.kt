package com.eshc.goonersapp.feature.home.state

import com.eshc.goonersapp.core.domain.model.match.MatchData

sealed interface RecentlyResultUiState {
    data object Loading: RecentlyResultUiState

    data class Success(val data: MatchData? = null): RecentlyResultUiState

    data class Failed(val message: String? = null): RecentlyResultUiState

    data class Error(val throwable: String? = null): RecentlyResultUiState
}