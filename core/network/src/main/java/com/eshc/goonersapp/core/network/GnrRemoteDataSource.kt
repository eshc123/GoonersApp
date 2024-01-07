package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.RemotePlayer

interface GnrRemoteDataSource {

    suspend fun getPlayerList() : List<RemotePlayer>

    suspend fun getPlayer(playerId : String) : RemotePlayer
}