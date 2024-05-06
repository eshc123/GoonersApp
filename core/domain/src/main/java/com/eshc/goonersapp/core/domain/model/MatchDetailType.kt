package com.eshc.goonersapp.core.domain.model

enum class MatchDetailType {
    GOAL,
    OWNGOAL,
    SUBSTITUTION,
    YELLOWCARD,
    REDCARD,
    YELLOWREDCARD,
    PENALTY,
    MISSED_PENALTY,
    UNKNOWN
}

fun String.toMatchDetailType() : MatchDetailType {
    return MatchDetailType.entries.find { it.name == this } ?: MatchDetailType.UNKNOWN
}