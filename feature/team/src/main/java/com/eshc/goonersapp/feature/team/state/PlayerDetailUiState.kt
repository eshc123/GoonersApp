package com.eshc.goonersapp.feature.team.state

import com.eshc.goonersapp.core.domain.model.player.Player

sealed class PlayerDetailUiState {
    data class Success(
        val playerDetail : Player
    ) : PlayerDetailUiState()

    data object Error : PlayerDetailUiState()

    data object Loading : PlayerDetailUiState()

}
