package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.player.RemotePlayer

interface PlayerNetworkDataSource {

    suspend fun getPlayerList() : NetworkResult<List<RemotePlayer>>

    suspend fun getPlayerDetail(playerId : Int) : NetworkResult<RemotePlayer>
}