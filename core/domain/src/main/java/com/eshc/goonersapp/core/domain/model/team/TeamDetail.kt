package com.eshc.goonersapp.core.domain.model.team

import com.eshc.goonersapp.core.domain.model.match.Match


data class TeamDetail(
    val team: Team,
    val recentlyMatches : List<Match> = emptyList()
)
