package com.eshc.goonersapp.feature.home.state

import com.eshc.goonersapp.core.domain.model.season.Rank

interface DashBoardUiState {
    data object Loading: DashBoardUiState

    data class Success(val data: List<Rank>): DashBoardUiState

    data class Failed(val message: String? = null): DashBoardUiState

    data class Error(val throwable: String? = null): DashBoardUiState
}