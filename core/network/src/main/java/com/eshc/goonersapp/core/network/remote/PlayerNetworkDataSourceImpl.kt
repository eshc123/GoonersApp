package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.api.PlayerNetworkService
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.handleApi
import com.eshc.goonersapp.core.network.model.player.RemotePlayer
import com.eshc.goonersapp.core.network.model.player.RemotePlayerList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerNetworkDataSourceImpl @Inject constructor(
    private val playerNetworkService: PlayerNetworkService
) : PlayerNetworkDataSource {

    override suspend fun getPlayerList(): NetworkResult<RemotePlayerList> {
        return handleApi {
            playerNetworkService.getPlayers()
        }
    }

    override suspend fun getPlayerDetail(playerId: Int): NetworkResult<RemotePlayer> {
        return handleApi {
            playerNetworkService.getPlayerDetail(playerId = playerId)
        }
    }
}
