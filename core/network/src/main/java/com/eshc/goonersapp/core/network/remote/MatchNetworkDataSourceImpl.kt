package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.api.MatchNetworkService
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.handleApi
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchData
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import com.eshc.goonersapp.core.network.model.match.RemoteMatchLineup
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchNetworkDataSourceImpl @Inject constructor(
    private val matchNetworkService: MatchNetworkService
) : MatchNetworkDataSource {
    override suspend fun getMatch(matchId: Int): NetworkResult<RemoteMatchData> {
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

    override suspend fun getMatchesBySeason(seasonId : Int): NetworkResult<List<RemoteMatch>> {
        return handleApi {
            matchNetworkService.getMatchesBySeason(seasonId = seasonId)
        }
    }

    override suspend fun getUpcomingMatches(): NetworkResult<List<RemoteMatch>> {
        return handleApi {
            matchNetworkService.getUpcomingMatches()
        }
    }

    override suspend fun getRecentlyMatch(): NetworkResult<RemoteMatchData> {
        return handleApi {
            matchNetworkService.getRecentlyMatch()
        }
    }

    override suspend fun getMatchLineup(matchId: Int): NetworkResult<RemoteMatchLineup> {
        return handleApi {
            matchNetworkService.getMatchLineup(matchId)
        }
    }
}
