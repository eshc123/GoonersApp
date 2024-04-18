package com.eshc.goonersapp.core.domain.model.match

data class Match(
    val id :Int = 0,
    val homeTeamId : Int = 0,
    val homeTeamName : String = "",
    val homeTeamImageUrl : String = "",
    val homeTeamNickname : String = "",
    val awayTeamId : Int = 0,
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
