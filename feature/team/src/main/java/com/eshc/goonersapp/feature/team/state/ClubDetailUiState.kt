package com.eshc.goonersapp.feature.team.state

import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.model.TeamDetail


sealed class ClubDetailUiState {
    data class Success(
        val teamDetail: TeamDetail
    ) : ClubDetailUiState()

    data object Error : ClubDetailUiState()

    data object Loading : ClubDetailUiState()

}