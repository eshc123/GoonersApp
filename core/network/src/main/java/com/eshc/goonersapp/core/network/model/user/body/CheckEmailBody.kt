package com.eshc.goonersapp.core.network.model.user.body

import kotlinx.serialization.Serializable

@Serializable
data class CheckEmailBody(
    val email : String
)
