package com.eshc.goonersapp.feature.home.state

import com.eshc.goonersapp.core.domain.model.match.Match

sealed interface UpcomingMatchesUiState {
    data object Loading: UpcomingMatchesUiState

    data class Success(val data: List<Match>): UpcomingMatchesUiState

    data class Failed(val message: String? = null): UpcomingMatchesUiState

    data class Error(val throwable: String? = null): UpcomingMatchesUiState

}