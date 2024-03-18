package com.eshc.goonersapp.core.network.model.user

import kotlinx.serialization.Serializable

@Serializable
data class RemoteLoginInfo(
    val email : String,
    val nickname : String,
    val teamId : Int,
    val accessToken : String,
    val refreshToken : String
)
