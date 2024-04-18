package com.eshc.goonersapp.core.network.model.team

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteTeam(
    @SerialName("team_id")
    val teamId :Int?,
    @SerialName("team_name")
    val teamName :String?,
    @SerialName("founded")
    val founded :Int?,
    @SerialName("team_image_url")
    val teamImageUrl :String?,
    @SerialName("short_code")
    val shortCode :String?,
    @SerialName("venue_name")
    val venueName :String?,
)
