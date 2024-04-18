package com.eshc.goonersapp.core.domain.model.match

data class MatchInformation(
    val notablePlayer: NotablePlayer? = null,
    val lineUp: List<LineUp>,
    val performance: List<Performance>
)

data class NotablePlayer(
    val playerId: Int,
    val playerName: String,
    val playerHeight: Int,
    val playerWeight: Int,
    val playerImageUrl: String,
    val playerPosition: String,
    val playerPositionInitial: String,
    val playerGoalCount: Int
)

data class LineUp(
    val lineUpId: Double,
    val matchId: Int,
    val playerId: Int,
    val teamId: Int,
    val playerName: String,
    val playerBackNumber: Int,
    val formationField: String?,
    val formationPosition: Int?,
    val positionId: Int,
    val positionCategory: String,
    val positionInitial: String
)

data class Performance(
    val result: String,
    val count: Int,
    val opponentImageUrl: String
)