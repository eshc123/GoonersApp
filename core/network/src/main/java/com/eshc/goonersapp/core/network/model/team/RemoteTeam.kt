package com.eshc.goonersapp.core.network.model.team

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteTeam(
    @SerialName("club_id")
    val id :Int,
    @SerialName("club_name")
    val clubName :String,
    @SerialName("official_name")
    val officialName :String,
    @SerialName("foundation_date")
    val foundationDate :String,
    @SerialName("image_url")
    val imageUrl :String,
    @SerialName("team_nickname")
    val teamNickname :String,
    @SerialName("manager_id")
    val managerId :Int,
    val manager :String,
    @SerialName("captain_id")
    val captainId :Int,
    val captain :String,
    @SerialName("stadium_name")
    val stadiumName :String,
)
