package com.eshc.goonersapp.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RemotePlayer(
    val id :String,
    val name : String = "",
    val backNumber : Int = 0,
    val position : String = "",
    val birthDate : String = "",
    val height : Int = 0,
    val weight : Int = 0,
    val imageUrl : String = "",
)
