package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchData
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation

interface MatchNetworkDataSource {

    suspend fun getMatch(matchId: Int): NetworkResult<RemoteMatchData>

    suspend fun getMatchInformation(
        matchId: Int,
        seasonId: Int,
        opponentId: Int
    ): NetworkResult<RemoteMatchInformation>

    suspend fun getMatchesBySeason(seasonId: Int): NetworkResult<List<RemoteMatch>>

    suspend fun getUpcomingMatches(): NetworkResult<List<RemoteMatch>>

    suspend fun getRecentlyMatch(): NetworkResult<RemoteMatchData>
}