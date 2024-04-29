package com.eshc.goonersapp.feature.home.state

import com.eshc.goonersapp.core.domain.model.match.MatchRecently

sealed interface RecentlyResultUiState {
    data object Loading: RecentlyResultUiState

    data class Success(val data: MatchRecently? = null): RecentlyResultUiState

    data class Failed(val message: String? = null): RecentlyResultUiState

    data class Error(val throwable: String? = null): RecentlyResultUiState
}