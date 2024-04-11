package com.eshc.goonersapp.core.network.model.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemotePlayer(
    @SerialName("player_id")
    val playerId :Int? = 0,
    @SerialName("player_name")
    val playerName : String? = "",
    @SerialName("back_number")
    val backNumber : Int? = 0,
    @SerialName("birth_date")
    val birthDate : String? = "",
    @SerialName("height")
    val height : Int? = 0,
    @SerialName("weight")
    val weight : Int? = 0,
    @SerialName("player_image")
    val playerImage : String? = "",
    @SerialName("position")
    val position : String? = "",
    @SerialName("position_initial")
    val positionInitial : String? = "",
    @SerialName("position_category")
    val positionCategory : String? = "",
    @SerialName("nationality")
    val nationality : String? = ""
)
