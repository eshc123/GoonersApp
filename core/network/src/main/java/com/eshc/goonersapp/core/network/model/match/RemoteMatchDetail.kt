package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatchDetail(
    @SerialName("match_detail_id") val matchDetailId: Int,
    @SerialName("match_id") val matchId: Int,
    @SerialName("team_id") val teamId: Int,
    @SerialName("player_id") val playerId: Int,
    @SerialName("related_player_id") val relatedPlayerId: Int? = 0,
    @SerialName("minute") val minute: Int,
    @SerialName("extra_minute") val extraMinute: Int? = 0,
    @SerialName("type") val type: String = "",
    @SerialName("player_name") val playerName: String = "",
    @SerialName("related_player_name") val relatedPlayerName: String? = ""
)