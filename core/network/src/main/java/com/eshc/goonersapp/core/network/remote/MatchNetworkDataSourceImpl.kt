package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.api.MatchNetworkService
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.handleApi
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import com.eshc.goonersapp.core.network.model.match.RemoteMatchTeam
import com.eshc.goonersapp.core.network.model.match.RemoteMatchUpcoming
import com.eshc.goonersapp.core.network.model.match.RemoteRecentlyMatch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchNetworkDataSourceImpl @Inject constructor(
    private val matchNetworkService: MatchNetworkService
) : MatchNetworkDataSource {
    override suspend fun getMatch(matchId: Int): NetworkResult<RemoteMatch> {
       return handleApi {
           matchNetworkService.getMatch(matchId = matchId)
       }
    }

    override suspend fun getMatchInformation(
        matchId: Int,
        seasonId: Int,
        opponentId: Int,
    ): NetworkResult<RemoteMatchInformation> {
        return handleApi {
            matchNetworkService.getMatchInformation(
                matchId = matchId,
                seasonId = seasonId,
                opponentId = opponentId
            )
        }
    }

    override suspend fun getMatchesBySeason(seasonId : Int): NetworkResult<List<RemoteMatchTeam>> {
        return handleApi {
            matchNetworkService.getMatchesBySeason(seasonId = seasonId)
        }
    }

    override suspend fun getUpcomingMatches(): NetworkResult<List<RemoteMatchUpcoming>> {
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
