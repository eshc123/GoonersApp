package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatchLineup(
    @SerialName("home_lineup") val homeLineup : RemoteTeamLineup = RemoteTeamLineup(),
    @SerialName("away_lineup") val awayLineup : RemoteTeamLineup = RemoteTeamLineup(),
)

@Serializable
data class RemoteTeamLineup(
    @SerialName("team_id") val teamId : Long = 0L,
    @SerialName("formation") val formation : String = "",
    @SerialName("players") val players : List<PlayerLineup> = emptyList()
)

@Serializable
data class PlayerLineup(
    @SerialName("lineup_id") val lineUpId: Long = 0L,
    @SerialName("match_id") val matchId: Int = 0,
    @SerialName("player_id") val playerId: Int = 0,
    @SerialName("team_id") val teamId: Int = 0,
    @SerialName("player_name") val playerName: String = "",
    @SerialName("player_image_url") val playerImageUrl: String = "",
    @SerialName("jersey_number") val jerseyNumber: Int = 0,
    @SerialName("formation_field") val formationField: String? = "",
    @SerialName("formation_position") val formationPosition: Int? = 0,
    @SerialName("position_id") val positionId: Int = 0,
    @SerialName("position_category") val positionCategory: String = "",
    @SerialName("position_initial") val positionInitial: String = ""
)