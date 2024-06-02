package com.eshc.goonersapp.feature.match.model

import android.os.Parcelable
import com.eshc.goonersapp.core.domain.model.match.Match
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Serializable
@Parcelize
data class MatchUiModel(
    val id: Int,
    val seasonId: Int = 0,
    val homeTeamName: String = "",
    val homeTeamNickname: String = "",
    val homeTeamImageUrl: String = "",
    val awayTeamName: String = "",
    val awayTeamNickname: String = "",
    val awayTeamImageUrl: String = "",
    val matchDate: String = "",
    val homeScore: Int = 0,
    val awayScore: Int = 0,
    val homeTeamId: Int = 0,
    val awayTeamId: Int = 0,
    val round: Int = 0,
    val isFinished: Boolean = false,
    val stadiumName: String = "",
    val leagueImageUrl: String = "",
) : Parcelable {
    val isScorelessMatch: Boolean
        get() = homeScore == 0 && awayScore == 0

    override fun toString(): String {
        return URLEncoder.encode(
            Json.encodeToString(this),
            StandardCharsets.UTF_8.toString()
        )
    }

    fun getMatchTitle(): String {
        val homeTeamNameTitle =
            if (homeTeamNickname.isBlank() && homeTeamName.length >= 2) homeTeamName.substring(0..2)
                .uppercase()
            else homeTeamNickname

        val awayTeamNameTitle =
            if (awayTeamNickname.isBlank() && awayTeamName.length >= 2) awayTeamName.substring(0..2)
                .uppercase()
            else awayTeamNickname

        return "$homeTeamNameTitle vs $awayTeamNameTitle"
    }

    fun getOpponentTeamId(myTeamId: Int): Int {
        return if (homeTeamId == myTeamId) awayTeamId
        else homeTeamId
    }

    fun getOpponentTeamName(myTeamId: Int): String {
        return if (homeTeamId == myTeamId) awayTeamName
        else homeTeamName
    }
}

fun Match.toUiModel() = MatchUiModel(
    id = id,
    seasonId = seasonId,
    homeTeamName = homeTeamName,
    homeTeamImageUrl = homeTeamImageUrl,
    homeTeamId = homeTeamId,
    awayTeamName = awayTeamName,
    awayTeamImageUrl = awayTeamImageUrl,
    awayTeamId = awayTeamId,
    matchDate = matchDate,
    homeScore = homeScore,
    awayScore = awayScore,
    round = round,
    isFinished = isFinished,
    stadiumName = stadiumName,
    leagueImageUrl = leagueImageUrl
)