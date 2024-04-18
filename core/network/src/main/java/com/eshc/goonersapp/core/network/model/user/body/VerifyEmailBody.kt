package com.eshc.goonersapp.core.network.model.user.body

import kotlinx.serialization.Serializable

@Serializable
data class VerifyEmailBody(
    val email : String,
    val code : String
)
