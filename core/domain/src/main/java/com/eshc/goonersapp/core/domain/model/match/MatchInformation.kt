package com.eshc.goonersapp.core.domain.model.match

data class MatchInformation(
    val notablePlayer: NotablePlayer? = null,
    val performance: Performance
)

data class NotablePlayer(
    val playerId: Int,
    val playerName: String,
    val playerHeight: Int,
    val playerWeight: Int,
    val playerImageUrl: String,
    val playerPosition: String,
    val playerPositionInitial: String,
    val playerGoalCount: Int,
    val playerParticipationCount : Int
)

data class Performance(
    val opponentImageUrl: String,
    val win: Int,
    val draw: Int,
    val lose: Int
)