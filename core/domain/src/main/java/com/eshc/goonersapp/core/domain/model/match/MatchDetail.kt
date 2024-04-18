package com.eshc.goonersapp.core.domain.model.match

import java.awt.Image

data class MatchDetail(
    val matchDetailId: Int,
    val matchId: Int,
    val teamId: Int,
    val playerId: Int,
    val relatedPlayerId: Int? = 0,
    val minute: Int,
    val extraMinute: Int? = 0,
    val type: String,
    val playerName: String,
    val relatedPlayerName: String? = ""
)