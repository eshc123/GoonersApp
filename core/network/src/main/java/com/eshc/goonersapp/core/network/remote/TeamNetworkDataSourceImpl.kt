package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.TeamNetworkDataSource
import com.eshc.goonersapp.core.network.api.TeamNetworkService
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.handleApi
import com.eshc.goonersapp.core.network.model.team.RemoteTeamDetail
import javax.inject.Inject

class TeamNetworkDataSourceImpl @Inject constructor(
    private val teamNetworkService: TeamNetworkService
) : TeamNetworkDataSource {
    override suspend fun getTeamDetail(): NetworkResult<RemoteTeamDetail> {
        return handleApi {
            teamNetworkService.getTeamDetail()
        }
    }
}