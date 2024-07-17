package com.eshc.goonersapp.feature.team.model

import com.eshc.goonersapp.core.domain.model.player.Player

data class TeamSearchUiModel(
    val players : List<Player> = emptyList(),
    val page : Int = 1,
    val isEnded : Boolean = false
)
