package com.eshc.goonersapp.core.network.model.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemotePlayer(
    @SerialName("player_id")
    val id :Int,
    @SerialName("player_name")
    val name : String = "",
    @SerialName("back_number")
    val backNumber : Int = 0,
    @SerialName("birth_date")
    val birthDate : String = "",
    @SerialName("stature")
    val height : Int = 0,
    @SerialName("weight")
    val weight : Int = 0,
    @SerialName("image_url")
    val imageUrl : String = "",
    @SerialName("contract_start_date")
    val contractStartDate : String = "",
    @SerialName("contract_end_date")
    val contractEndDate : String = "",
    @SerialName("main_position")
    val mainPosition : String = "", // ex) Right Back
    @SerialName("category")
    val positionCategory : String = "", // ex) Defender
    @SerialName("initial")
    val positionInitial : String = "", // RB
    @SerialName("nationality1")
    val nationality : String = "", // RB
)
