package com.eshc.goonersapp.core.network.model.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteSeason(
    @SerialName("season_id") val seasonId : Int,
    @SerialName("season") val season : String
)