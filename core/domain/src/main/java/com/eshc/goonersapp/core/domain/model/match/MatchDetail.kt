package com.eshc.goonersapp.core.domain.model.match

import com.eshc.goonersapp.core.domain.model.MatchDetailType

data class MatchDetail(
    val matchDetailId: Int,
    val matchId: Int,
    val teamId: Int,
    val playerId: Int,
    val relatedPlayerId: Int? = 0,
    val minute: Int,
    val extraMinute: Int? = 0,
    val matchDetailType: MatchDetailType,
    val playerName: String,
    val relatedPlayerName: String? = ""
) {
    val isScoredMatchDetailType: Boolean
        get() = matchDetailType in setOf(MatchDetailType.GOAL, MatchDetailType.PENALTY, MatchDetailType.OWNGOAL)

    val scoringRecordText: String
        get() = "$playerName (${minute}`)" +
                when (matchDetailType) {
                    MatchDetailType.PENALTY -> " PK"
                    MatchDetailType.OWNGOAL -> " OG"
                    else -> ""
                }

}

fun List<MatchDetail>.getScoreHistoryList(teamId: Int? = null) =
    this.filter {
        it.isScoredMatchDetailType && (teamId == null || it.teamId == teamId)
    }