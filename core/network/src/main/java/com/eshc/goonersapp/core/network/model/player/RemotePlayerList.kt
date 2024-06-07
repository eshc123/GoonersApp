package com.eshc.goonersapp.core.network.model.player

import kotlinx.serialization.Serializable

@Serializable

data class RemotePlayerList(
    val teamPlayer : List<RemotePlayer>,
    val page : Int? = 0,
    val size : Int? = 0
)
