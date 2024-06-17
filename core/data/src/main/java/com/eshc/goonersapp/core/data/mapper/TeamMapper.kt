package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.team.Team
import com.eshc.goonersapp.core.domain.model.team.TeamDetail
import com.eshc.goonersapp.core.network.model.team.RemoteTeam
import com.eshc.goonersapp.core.network.model.team.RemoteTeamDetail

fun RemoteTeamDetail.toModel() = TeamDetail(
    team = team.toModel(),
    recentlyMatches = recentlyMatchs.map { it.toModel() }
)

fun RemoteTeam.toModel() = Team(
    clubId = teamId ?: 0,
    clubName = teamName ?: "",
    clubFoundedYear = founded ?: 0,
    clubImgUrl = teamImageUrl ?: "",
    clubShortCode = shortCode ?: "",
    manager = managerName ?: "",
    captain = captainName ?: "",
    stadiumName = venueName ?: "",
    clubHomeTown = cityName ?: "",
    clubNationality = nationality ?: "",
    clubNationImgUrl = nationalityImgUrl ?: "",
    officialWebUrl = officialWebUrl ?: "",
    snsFaceBook = snsFacebook ?: "",
    snsX = snsX ?: "",
    snsInstagram = snsInstagram ?: ""
)