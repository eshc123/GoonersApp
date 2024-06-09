package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.player.RemotePlayer
import com.eshc.goonersapp.core.network.model.player.RemotePlayerList

interface PlayerNetworkDataSource {

    suspend fun getPlayerList() : NetworkResult<RemotePlayerList>

    suspend fun getPlayerDetail(playerId : Int) : NetworkResult<RemotePlayer>
}