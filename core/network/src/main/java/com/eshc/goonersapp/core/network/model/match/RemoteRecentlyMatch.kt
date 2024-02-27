package com.eshc.goonersapp.core.network.model.match

import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import kotlinx.serialization.Serializable

@Serializable
data class RemoteRecentlyMatch(
    val match : RemoteMatch,
)
