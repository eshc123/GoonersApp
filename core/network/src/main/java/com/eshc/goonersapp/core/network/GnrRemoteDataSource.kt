package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.RemotePlayer

interface GnrRemoteDataSource {

    suspend fun getPlayers() : List<RemotePlayer>
}