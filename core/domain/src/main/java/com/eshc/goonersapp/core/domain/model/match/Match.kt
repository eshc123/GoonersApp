package com.eshc.goonersapp.core.domain.model.match

import com.eshc.goonersapp.core.domain.model.common.MatchResult

data class Match(
    val id :Int = 0,
    val seasonId : Int = 0,
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
){
    val matchScore = "${homeScore}:${awayScore}"

    fun getOpponentTeamImage(myTeamId : Int) : String {
        return if(myTeamId == homeTeamId) awayTeamImageUrl
        else homeTeamImageUrl
    }

    fun getOpponentTeamNickname(myTeamId : Int) : String {
        return if(myTeamId == homeTeamId) awayTeamNickname
        else homeTeamNickname
    }

    fun getOpponentTeamImageUrl(myTeamId : Int) : String {
        return if(myTeamId == homeTeamId) awayTeamImageUrl
        else homeTeamImageUrl
    }

    fun getMatchResult(myTeamId : Int) : MatchResult {
        return if(homeScore == awayScore) MatchResult.Draw
        else if(myTeamId == homeTeamId && homeScore > awayScore ||
            myTeamId == awayTeamId && awayScore > homeScore) MatchResult.Win
        else MatchResult.Loss
    }
}
