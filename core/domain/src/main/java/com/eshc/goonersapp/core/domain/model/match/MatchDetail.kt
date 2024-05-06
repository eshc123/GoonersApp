package com.eshc.goonersapp.core.domain.model.match

data class MatchDetail(
    val matchDetailId: Int,
    val matchId: Int,
    val teamId: Int,
    val playerId: Int,
    val relatedPlayerId: Int? = 0,
    val minute: Int,
    val extraMinute: Int? = 0,
    val type: MatchDetailType,
    val playerName: String,
    val relatedPlayerName: String? = ""
) {

    val isScoredMatchDetailType: Boolean
        get() = type in MatchDetailType.scoredTypes

    val scoringRecordText: String
        get() = "$playerName (${minute}`)" +
                when (type) {
                    MatchDetailType.PENALTY -> " PK"
                    MatchDetailType.OWNGOAL -> " OG"
                    else -> ""
                }

}

fun List<MatchDetail>.getScoreHistoryList(teamId: Int? = null) =
    this.filter {
        it.isScoredMatchDetailType && (teamId == null || it.teamId == teamId)
    }