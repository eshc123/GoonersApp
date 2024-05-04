package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatch(
    @SerialName("match_id") val matchId: Int = 0,
    @SerialName("season_id") val seasonId: Int = 0,
    @SerialName("home_team_id") val homeTeamId: Int = 0,
    @SerialName("home_team_name") val homeTeamName: String = "",
    @SerialName("home_team_nickname") val homeTeamNickname: String = "",
    @SerialName("home_team_image_url") val homeTeamImage: String = "",
    @SerialName("away_team_id") val awayTeamId: Int = 0,
    @SerialName("away_team_name") val awayTeamName: String = "",
    @SerialName("away_team_nickname") val awayTeamNickname: String = "",
    @SerialName("away_team_image_url") val awayTeamImage: String = "",
    @SerialName("match_date") val matchDate: String = "",
    @SerialName("home_score") val homeScore: Int = 0,
    @SerialName("away_score") val awayScore: Int = 0,
    @SerialName("round") val round: Int = 0,
    @SerialName("is_finished") val isFinished: Int = 0,
    @SerialName("venue_name") val venueName: String? = "",
    @SerialName("league_image_url") val leagueImage: String = ""
)