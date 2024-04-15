package com.eshc.goonersapp.core.network.model.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMatch(
    @SerialName("match") val match: RemoteMatchTeam,
    @SerialName("matchDetail") val matchDetail: List<RemoteMatchDetail>
)