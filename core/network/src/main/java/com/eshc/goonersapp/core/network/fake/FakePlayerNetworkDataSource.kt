package com.eshc.goonersapp.core.network.fake

import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.player.RemotePlayer

class FakePlayerNetworkDataSource : PlayerNetworkDataSource {

    private var responseForPlayerList : (() -> NetworkResult<List<RemotePlayer>>)? = null
    private var responseForPlayerDetail : (() -> NetworkResult<RemotePlayer>)? = null

    fun setResponseForPlayerList(response: () -> NetworkResult<List<RemotePlayer>>) {
        this.responseForPlayerList = response
    }

    fun setResponseForPlayerDetail(response: () -> NetworkResult<RemotePlayer>) {
        this.responseForPlayerDetail = response
    }

    override suspend fun getPlayerList(): NetworkResult<List<RemotePlayer>> {
        return responseForPlayerList?.invoke() ?: throw IllegalStateException("Response for getPlayerList not set")
    }

    override suspend fun getPlayerDetail(playerId: Int): NetworkResult<RemotePlayer> {
        return responseForPlayerDetail?.invoke() ?: throw IllegalStateException("Response for getPlayerDetail not set")
    }
}