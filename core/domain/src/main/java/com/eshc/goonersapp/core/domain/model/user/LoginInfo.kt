package com.eshc.goonersapp.core.domain.model.user

data class LoginInfo(
    val email : String,
    val nickname : String,
    val teamId : Int,
    val accessToken : String,
    val refreshToken : String
)

