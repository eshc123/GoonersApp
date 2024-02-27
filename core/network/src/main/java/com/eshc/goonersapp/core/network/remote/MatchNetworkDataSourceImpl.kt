package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.api.MatchNetworkService
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.handleApi
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteRecentlyMatch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchNetworkDataSourceImpl @Inject constructor(
    private val matchNetworkService: MatchNetworkService
) : MatchNetworkDataSource {

    override suspend fun getMatchesBySeason(season : String): NetworkResult<List<RemoteMatch>> {
        return handleApi {
            matchNetworkService.getMatchesBySeason(season = season)
        }
    }

    override suspend fun getUpcomingMatches(): NetworkResult<List<RemoteMatch>> {
        return handleApi {
            matchNetworkService.getUpcomingMatches()
        }
    }

    override suspend fun getRecentlyMatch(): NetworkResult<RemoteRecentlyMatch> {
        return handleApi {
            matchNetworkService.getRecentlyMatch()
        }
    }
}
