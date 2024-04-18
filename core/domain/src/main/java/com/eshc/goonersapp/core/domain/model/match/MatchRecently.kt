package com.eshc.goonersapp.core.domain.model.match

data class MatchRecently(
    val match: Match,
    val matchDetail: List<MatchDetail>
)