package com.eshc.goonersapp.core.domain.model


data class TeamDetail(
    val team: Team,
    val recentlyMatches : List<Match> = emptyList()
)
