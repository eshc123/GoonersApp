package com.eshc.goonersapp.core.domain.model.team

import com.eshc.goonersapp.core.domain.model.match.Match


data class TeamDetail(
    val team: Team,
    val recentlyMatches : List<Match> = emptyList()
) {
    fun officialWebUrlIsNotEmpty(): Boolean = team.officialWebUrl.isNotEmpty()

    fun socialMediaIsNotEmpty(): Boolean {
        return !(team.snsX.isEmpty() && team.snsFaceBook.isEmpty() && team.snsInstagram.isEmpty())
    }

    fun snsXisNotEmpty(): Boolean = team.snsX.isNotEmpty()

    fun snsFaceBookIsNotEmpty(): Boolean = team.snsFaceBook.isNotEmpty()

    fun snsInstagramIsNotEmpty(): Boolean = team.snsInstagram.isNotEmpty()

    fun matchesLastIndex(): Int = recentlyMatches.lastIndex

    fun matchesIsNotEmpty(): Boolean = recentlyMatches.isNotEmpty()
}