package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.network.model.match.RemoteMatch

fun RemoteMatch.toModel() = Match(
    id = id,
    homeTeamId = homeTeamId,
    homeTeamName = homeTeamName,
    homeTeamImageUrl = homeTeamImage,
    homeTeamNickname = homeTeamNickname,
    awayTeamId = awayTeamId,
    awayTeamName = awayTeamName,
    awayTeamImageUrl = awayTeamImage,
    awayTeamNickname = awayTeamNickname,
    matchDate = matchDate,
    homeScore = homeScore,
    awayScore = awayScore,
    round = round,
    isFinished = isFinished == 1,
    stadiumName = stadiumName,
    leagueImageUrl = leagueImageUrl
)