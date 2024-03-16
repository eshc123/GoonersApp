package com.eshc.goonersapp.core.network.model.user.body

import kotlinx.serialization.Serializable

@Serializable
data class LoginBody(
    val email : String,
    val password : String,
    val deviceToken : String
)
