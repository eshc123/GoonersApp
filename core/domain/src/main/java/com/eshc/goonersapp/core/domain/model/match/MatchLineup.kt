package com.eshc.goonersapp.core.domain.model.match

data class MatchLineup(
    val homeLineup : TeamLineup,
    val awayLineup : TeamLineup
)

data class TeamLineup(
    val teamId : Int,
    val formation : String,
    val playerLineup : List<PlayerLineup>
)

data class PlayerLineup(
    val lineUpId: Long,
    val matchId: Int,
    val playerId: Int,
    val teamId: Int,
    val playerName: String,
    val playerImageUrl : String,
    val playerBackNumber: Int,
    val formationField: String?,
    val formationPosition: Int?,
    val positionId: Int,
    val positionCategory: String,
    val positionInitial: String
)