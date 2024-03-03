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
    clubId = id,
    clubName = clubName,
    officialName = officialName,
    foundationDate = foundationDate,
    imageUrl = imageUrl,
    teamNickname = teamNickname,
    managerId = managerId,
    manager = manager,
    captainId = captainId,
    captain = captain,
    stadiumName = stadiumName
)