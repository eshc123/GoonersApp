package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.player.RemotePlayer
import com.eshc.goonersapp.core.network.model.player.RemotePlayerList

interface PlayerNetworkDataSource {

    suspend fun getPlayerList(
        teamId : Int = 19,
        seasonId : Int = 21646,
        positionId : Int?  = null,
        keyword : String? = null,
        page : Int? = null,
        size : Int? = null
    ) : NetworkResult<RemotePlayerList>

    suspend fun getPlayerDetail(playerId : Int) : NetworkResult<RemotePlayer>
}