package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatchInformation(
    @SerialName("notablePlayer") val notablePlayer: NotablePlayer? = null,
    @SerialName("performance") val performance: Performance
)

@Serializable
data class NotablePlayer(
    @SerialName("player_id") val playerId: Int,
    @SerialName("player_name") val playerName: String,
    @SerialName("height") val height: Int,
    @SerialName("weight") val weight: Int,
    @SerialName("player_image_url") val playerImage: String,
    @SerialName("position") val position: String,
    @SerialName("position_initial") val positionInitial: String,
    @SerialName("goal_count") val goalCount: Int
)

@Serializable
data class Performance(
    @SerialName("opponent_image_url") val opponentImage: String = "",
    @SerialName("WIN") val win: Int = 0,
    @SerialName("LOSE") val lose: Int = 0,
    @SerialName("DRAW") val draw: Int = 0,
)