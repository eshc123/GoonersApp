package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatchUpcoming(
    @SerialName("match_id") val matchId: Int,
    @SerialName("home_team_id") val homeTeamId: Int,
    @SerialName("home_team_nickname") val homeTeamNickname: String = "",
    @SerialName("home_team_name") val homeTeamName: String = "",
    @SerialName("home_team_image") val homeTeamImage: String = "",
    @SerialName("away_team_id") val awayTeamId: Int,
    @SerialName("away_team_nickname") val awayTeamNickname: String = "",
    @SerialName("away_team_name") val awayTeamName: String = "",
    @SerialName("away_team_image") val awayTeamImage: String = "",
    @SerialName("match_date") val matchDate: String = "",
    @SerialName("venue_name") val stadiumName: String? = "",
    @SerialName("league_image") val leagueImage: String = "",
)