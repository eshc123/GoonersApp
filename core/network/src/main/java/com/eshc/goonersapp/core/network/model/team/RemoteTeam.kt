package com.eshc.goonersapp.core.network.model.team

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteTeam(
    @SerialName("team_id") val teamId: Int?,
    @SerialName("team_name") val teamName: String?,
    @SerialName("founded") val founded: Int?,
    @SerialName("team_image_url") val teamImageUrl: String?,
    @SerialName("short_code") val shortCode: String?,
    @SerialName("manager_name") val managerName: String?,
    @SerialName("captain_player_name") val captainName: String?,
    @SerialName("venue_name") val venueName: String?,
    @SerialName("city_name") val cityName: String?,
    @SerialName("nationality") val nationality: String?,
    @SerialName("nationality_image_url") val nationalityImgUrl: String?,
    @SerialName("official_web_url") val officialWebUrl: String?,
    @SerialName("sns_facebook") val snsFacebook: String?,
    @SerialName("sns_x") val snsX: String?,
    @SerialName("sns_instagram") val snsInstagram: String?
)
