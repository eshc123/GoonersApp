package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatchInformation(
    @SerialName("notablePlayer") val notablePlayer: NotablePlayer? = null,
    @SerialName("lineUp") val lineUp: List<LineUp>,
    @SerialName("performance") val performance: List<Performance>
)

@Serializable
data class NotablePlayer(
    @SerialName("player_id") val playerId: Int,
    @SerialName("player_name") val playerName: String,
    @SerialName("height") val height: Int,
    @SerialName("weight") val weight: Int,
    @SerialName("player_image") val playerImage: String,
    @SerialName("position") val position: String,
    @SerialName("position_initial") val positionInitial: String,
    @SerialName("goal_count") val goalCount: Int
)

@Serializable
data class LineUp(
    @SerialName("lineup_id") val lineUpId: Double = 0.0,
    @SerialName("match_id") val matchId: Int = 0,
    @SerialName("player_id") val playerId: Int = 0,
    @SerialName("team_id") val teamId: Int = 0,
    @SerialName("player_name") val playerName: String = "",
    @SerialName("jersey_number") val jerseyNumber: Int = 0,
    @SerialName("formation_field") val formationField: String? = "",
    @SerialName("formation_position") val formationPosition: Int? = 0,
    @SerialName("position_id") val positionId: Int = 0,
    @SerialName("position_category") val positionCategory: String = "",
    @SerialName("position_initial") val positionInitial: String = ""
)

@Serializable
data class Performance(
    @SerialName("result") val result: String = "",
    @SerialName("count") val count: Int = 0,
    @SerialName("opponent_image") val opponentImage: String = ""
)