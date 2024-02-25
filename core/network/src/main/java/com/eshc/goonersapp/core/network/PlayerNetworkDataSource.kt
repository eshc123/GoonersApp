package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.player.RemotePlayer

interface PlayerNetworkDataSource {

    suspend fun getPlayerList() : List<RemotePlayer>

    suspend fun getPlayerDetail(playerId : Int) : RemotePlayer
}