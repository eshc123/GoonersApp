package com.eshc.goonersapp.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatch(
    @SerialName("match_id")
    val id :Int,
    @SerialName("home_team_id")
    val homeTeamId : Int,
    @SerialName("home_team_name")
    val homeTeamName : String = "",
    @SerialName("home_team_image")
    val homeTeamImage : String = "",
    @SerialName("home_team_nickname")
    val homeTeamNickname : String = "",
    @SerialName("away_team_id")
    val awayTeamId : Int,
    @SerialName("away_team_name")
    val awayTeamName : String = "",
    @SerialName("away_team_image")
    val awayTeamImage : String = "",
    @SerialName("away_team_nickname")
    val awayTeamNickname : String = "",
    @SerialName("match_date")
    val matchDate : String = "",
    @SerialName("home_score")
    val homeScore :Int = 0,
    @SerialName("away_score")
    val awayScore :Int = 0,
    @SerialName("round")
    val round :Int = 0,
    @SerialName("is_finished")
    val isFinished :Int = 0,
    @SerialName("stadium_name")
    val stadiumName : String = "",
    @SerialName("league_image_url")
    val leagueImageUrl : String = "",
)
