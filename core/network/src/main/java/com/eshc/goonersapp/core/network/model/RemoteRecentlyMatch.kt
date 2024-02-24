package com.eshc.goonersapp.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RemoteRecentlyMatch(
    val match :RemoteMatch,
)
