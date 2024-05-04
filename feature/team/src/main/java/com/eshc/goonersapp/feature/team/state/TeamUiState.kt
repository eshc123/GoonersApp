package com.eshc.goonersapp.feature.team.state

import com.eshc.goonersapp.core.domain.model.player.Player

sealed class TeamUiState {
    data class Success(
        val players : List<Player>
    ) : TeamUiState()

    data object Error : TeamUiState()

    data object Loading : TeamUiState()

}
