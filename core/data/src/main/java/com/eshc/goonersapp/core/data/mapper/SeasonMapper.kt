package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.season.League
import com.eshc.goonersapp.core.domain.model.season.Rank
import com.eshc.goonersapp.core.domain.model.season.Season
import com.eshc.goonersapp.core.network.model.season.RemoteLeague
import com.eshc.goonersapp.core.network.model.season.RemoteRank
import com.eshc.goonersapp.core.network.model.season.RemoteSeason

fun RemoteLeague.toModel() = League(
    leagueId = leagueId,
    leagueName = leagueName,
    shortCode = shortCode,
    leagueImgUrl = leagueImageUrl,
    seasonId = seasonId,
    season = season,
    teamId = teamId
)

fun RemoteSeason.toModel() = Season(seasonId = seasonId, season = season)

fun RemoteRank.toModel() = Rank(
    standingId = standingId,
    position = position,
    points = points,
    wins = win,
    loss = loss,
    draw = draw,
    goalDifference = goalDifference,
    teamId = teamId,
    teamName = teamName,
    shortCode = shortCode
)