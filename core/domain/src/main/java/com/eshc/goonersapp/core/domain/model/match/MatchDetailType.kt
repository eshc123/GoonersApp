package com.eshc.goonersapp.core.domain.model.match

enum class MatchDetailType {
    GOAL,
    OWNGOAL,
    SUBSTITUTION,
    YELLOWCARD,
    REDCARD,
    YELLOWREDCARD,
    PENALTY,
    MISSED_PENALTY,
    UNKNOWN;

    companion object {
        val scoredTypes = setOf(GOAL, PENALTY, OWNGOAL)
    }
}

fun String.toMatchDetailType() : MatchDetailType {
    return MatchDetailType.entries.find { it.name == this } ?: MatchDetailType.UNKNOWN
}