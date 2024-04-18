package com.eshc.goonersapp.core.network.model.user.body

import kotlinx.serialization.Serializable

@Serializable
data class SignUpBody(
    val email : String,
    val password : String,
    val nickname : String,
    val teamId : Int
)
