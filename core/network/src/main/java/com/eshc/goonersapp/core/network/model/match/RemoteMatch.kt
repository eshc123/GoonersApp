package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatch(
    @SerialName("match_id")
    val id :Int?,
    @SerialName("season_id")
    val seasonId : Int?,
    @SerialName("home_team_id")
    val homeTeamId : Int?,
    @SerialName("home_team_name")
    val homeTeamName : String?,
    @SerialName("home_team_image_url")
    val homeTeamImageUrl : String?,
    @SerialName("home_team_nickname")
    val homeTeamNickname : String?,
    @SerialName("away_team_id")
    val awayTeamId : Int?,
    @SerialName("away_team_name")
    val awayTeamName : String?,
    @SerialName("away_team_image_url")
    val awayTeamImageUrl : String?,
    @SerialName("away_team_nickname")
    val awayTeamNickname : String?,
    @SerialName("match_date")
    val matchDate : String?,
    @SerialName("home_score")
    val homeScore :Int?,
    @SerialName("away_score")
    val awayScore :Int?,
    @SerialName("round")
    val round :Int?,
    @SerialName("is_finished")
    val isFinished :Int?,
    @SerialName("venue_name")
    val venueName : String?,
    @SerialName("league_image")
    val leagueImage : String?,
)
