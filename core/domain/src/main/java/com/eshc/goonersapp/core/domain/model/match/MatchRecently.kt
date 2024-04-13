package com.eshc.goonersapp.core.domain.model.match

data class MatchRecently(
    val match: MatchUpcoming,
    val matchDetail: List<MatchDetail>
)