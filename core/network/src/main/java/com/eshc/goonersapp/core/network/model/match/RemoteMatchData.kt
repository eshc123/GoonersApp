package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatchData(
    @SerialName("match") val match: RemoteMatch,
    @SerialName("matchDetail") val matchDetail: List<RemoteMatchDetail>
)