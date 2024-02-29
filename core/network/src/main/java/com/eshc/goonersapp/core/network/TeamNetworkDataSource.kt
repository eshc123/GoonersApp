package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.team.RemoteTeamDetail

interface TeamNetworkDataSource {
    suspend fun getTeamDetail() : NetworkResult<RemoteTeamDetail>
}