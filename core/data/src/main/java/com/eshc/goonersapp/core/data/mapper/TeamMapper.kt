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
    officialName = "",
    foundationDate = (founded ?: 0).toString(),
    imageUrl = teamImageUrl ?: "",
    teamNickname = shortCode ?: "",
    managerId = 0,
    manager = "",
    captainId = 0,
    captain = "",
    stadiumName = venueName ?:""
)