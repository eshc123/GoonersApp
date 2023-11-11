package com.eshc.goonersapp.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RemotePlayer(
    val id :String,
    val name : String = "",
    val backNumber : Int = 0,
    val position : String = "",
    val imageUrl : String = "",
)
