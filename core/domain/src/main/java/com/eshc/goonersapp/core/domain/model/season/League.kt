package com.eshc.goonersapp.core.domain.model.season

data class League(
    val leagueId: Int,
    val leagueName: String,
    val shortCode: String,
    val leagueImgUrl: String,
    val seasonId: Int,
    val season: String,
    val teamId: Int
)