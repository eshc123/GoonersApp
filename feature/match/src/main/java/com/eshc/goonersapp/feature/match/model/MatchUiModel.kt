package com.eshc.goonersapp.feature.match.model

import android.os.Parcelable
import com.eshc.goonersapp.core.domain.model.Match
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Serializable
@Parcelize
data class MatchUiModel(
    val id :Int,
    val homeTeamName : String = "",
    val homeTeamImageUrl : String = "",
    val awayTeamName : String = "",
    val awayTeamImageUrl : String = "",
    val matchDate : String = "",
    val homeScore :Int = 0,
    val awayScore :Int = 0,
    val round :Int = 0,
    val isFinished :Boolean = false,
    val stadiumName : String = "",
    val leagueImageUrl : String = "",
) : Parcelable {
    override fun toString(): String {
        return URLEncoder.encode(
            Json.encodeToString(this),
            StandardCharsets.UTF_8.toString()
        )
    }
}

fun Match.toUiModel() = MatchUiModel(
    id = id,
    homeTeamName = homeTeamName,
    homeTeamImageUrl= homeTeamImageUrl,
    awayTeamName = awayTeamName,
    awayTeamImageUrl = awayTeamImageUrl,
    matchDate = matchDate,
    homeScore = homeScore,
    awayScore = awayScore,
    round = round,
    isFinished = isFinished,
    stadiumName = stadiumName,
    leagueImageUrl = leagueImageUrl
)