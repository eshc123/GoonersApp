package com.eshc.goonersapp.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val result : T
)