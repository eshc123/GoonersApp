package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.network.model.RemoteMatch

fun RemoteMatch.toModel() = Match(
    id = id,
    homeTeamName = homeTeamName,
    homeTeamImageUrl = homeTeamIamge,
    awayTeamName = awayTeamName,
    awayTeamImageUrl = awayTeamIamge,
    matchDate = matchDate,
    homeScore = homeScore,
    awayScore = awayScore,
    round = round,
    isFinished = isFinished == 1,
    stadiumName = stadiumName,
    leagueImageUrl = leagueImageUrl
)