package com.eshc.goonersapp.core.network.fake

import com.eshc.goonersapp.core.network.TeamNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.team.RemoteTeamDetail

class FakeTeamNetworkDataSource : TeamNetworkDataSource {

    private var responseForTeamDetail : (() -> NetworkResult<RemoteTeamDetail>)? = null

    fun setResponseForTeamDetail(response: () -> NetworkResult<RemoteTeamDetail>) {
        this.responseForTeamDetail = response
    }

    override suspend fun getTeamDetail(): NetworkResult<RemoteTeamDetail>  {
        return responseForTeamDetail?.invoke() ?: throw IllegalStateException("Response for getTeamDetail not set")
    }
}