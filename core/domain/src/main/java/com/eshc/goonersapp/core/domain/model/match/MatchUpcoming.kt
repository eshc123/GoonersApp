package com.eshc.goonersapp.core.domain.model.match

data class MatchUpcoming(
    val matchId: Int,
    val homeTeamId: Int,
    val homeTeamNickname: String,
    val homeTeamName: String,
    val homeTeamImageUrl: String,
    val awayTeamId: Int,
    val awayTeamNickname: String,
    val awayTeamName: String,
    val awayTeamImageUrl: String,
    val matchDate: String,
    val stadiumName: String? = "",
    val leagueImageUrl: String
)