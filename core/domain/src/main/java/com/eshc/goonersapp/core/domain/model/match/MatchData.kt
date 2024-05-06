package com.eshc.goonersapp.core.domain.model.match

data class MatchData(
    val match: Match,
    val matchDetail: List<MatchDetail>
){
    fun getScoreHistoryList(teamId: Int? = null) =
        matchDetail.filter {
            it.isScoredMatchDetailType && (teamId == null || it.teamId == teamId)
        }
}