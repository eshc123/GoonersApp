package com.eshc.goonersapp.core.network.fake

import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchData
import com.eshc.goonersapp.core.network.model.player.RemotePlayer

class FakePlayerNetworkDataSource : PlayerNetworkDataSource {

    private var responseForPlayerList: (() -> List<RemotePlayer>)? = null
    private var responseForPlayerDetail: (() -> RemotePlayer)? = null

    fun setResponseForPlayerList(response: () -> List<RemotePlayer>) {
        this.responseForPlayerList = response
    }

    fun setResponseForPlayerDetail(response: () -> RemotePlayer) {
        this.responseForPlayerDetail = response
    }

    override suspend fun getPlayerList(): NetworkResult<List<RemotePlayer>> {
        val response = responseForPlayerList?.invoke()
        return if (response != null) {
            NetworkResult.Success(response)
        } else {
            NetworkResult.Error(code = 404, message = "Response for getPlayerList not se")
        }
    }

    override suspend fun getPlayerDetail(playerId: Int): NetworkResult<RemotePlayer> {
        val response = responseForPlayerDetail?.invoke()
        return if (response != null) {
            NetworkResult.Success(response)
        } else {
            NetworkResult.Error(code = 404, message = "Response for getPlayerList not se")
        }
    }
}