package com.eshc.goonersapp.core.network.model.user

import kotlinx.serialization.Serializable

@Serializable
data class LoginInfo(
    val email : String,
    val nickname : String,
    val teamId : Int,
    val accessToken : String
)
