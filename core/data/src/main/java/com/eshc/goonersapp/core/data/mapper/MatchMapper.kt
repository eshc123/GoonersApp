package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.network.model.match.RemoteMatch

fun RemoteMatch.toModel() = Match(
    id = id ?: 0,
    homeTeamId = homeTeamId ?: 0,
    homeTeamName = homeTeamName ?: "",
    homeTeamImageUrl = homeTeamImageUrl ?: "",
    homeTeamNickname = homeTeamNickname ?: "",
    awayTeamId = awayTeamId ?: 0,
    awayTeamName = awayTeamName ?: "",
    awayTeamImageUrl = awayTeamImageUrl ?: "",
    awayTeamNickname = awayTeamNickname ?: "",
    matchDate = matchDate ?: "",
    homeScore = homeScore ?: 0,
    awayScore = awayScore ?: 0,
    round = round ?: 0,
    isFinished = isFinished == 1,
    stadiumName = venueName ?: "",
    leagueImageUrl = leagueImage ?: ""
)