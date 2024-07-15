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

    override suspend fun getPlayerList(
        teamId : Int,
        seasonId : Int,
        positionId : Int?,
        keyword : String?,
        page : Int?,
        size : Int?
    ): NetworkResult<RemotePlayerList> {
        return handleApi {
            playerNetworkService.getPlayers(
                teamId = teamId,
                seasonId = seasonId,
                positionId = positionId,
                keyword = keyword,
                page = page,
                size = size
            )
        }
    }

    override suspend fun getPlayerDetail(playerId: Int): NetworkResult<RemotePlayer> {
        return handleApi {
            playerNetworkService.getPlayerDetail(playerId = playerId)
        }
    }
}
