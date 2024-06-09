package com.eshc.goonersapp.core.network.model.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteRank(
    @SerialName("standing_id") val standingId : Int,
    @SerialName("position") val position : Int,
    @SerialName("points") val points : Int,
    @SerialName("win") val win : Int,
    @SerialName("loss") val loss : Int,
    @SerialName("draw") val draw : Int,
    @SerialName("goal_difference") val goalDifference : Int,
    @SerialName("team_id") val teamId : Int,
    @SerialName("team_name") val teamName : String,
    @SerialName("team_image_url") val teamImgUrl: String,
    @SerialName("short_code") val shortCode : String,
)