package com.eshc.goonersapp.core.domain.model

data class Match(
    val id :Int,
    val homeTeamId : Int,
    val homeTeamName : String = "",
    val homeTeamImageUrl : String = "",
    val homeTeamNickname : String = "",
    val awayTeamId : Int,
    val awayTeamName : String = "",
    val awayTeamImageUrl : String = "",
    val awayTeamNickname : String = "",
    val matchDate : String = "",
    val homeScore :Int = 0,
    val awayScore :Int = 0,
    val round :Int = 0,
    val isFinished :Boolean = false,
    val stadiumName : String = "",
    val leagueImageUrl : String = "",
)
