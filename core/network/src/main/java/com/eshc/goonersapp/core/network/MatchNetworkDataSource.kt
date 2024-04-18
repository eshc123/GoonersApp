package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import com.eshc.goonersapp.core.network.model.match.RemoteMatchTeam
import com.eshc.goonersapp.core.network.model.match.RemoteMatchUpcoming
import com.eshc.goonersapp.core.network.model.match.RemoteRecentlyMatch

interface MatchNetworkDataSource {

    suspend fun getMatch(matchId: Int): NetworkResult<RemoteMatch>

    suspend fun getMatchInformation(
        matchId: Int,
        seasonId: Int,
        opponentId: Int
    ): NetworkResult<RemoteMatchInformation>

    suspend fun getMatchesBySeason(seasonId: Int): NetworkResult<List<RemoteMatchTeam>>

    suspend fun getUpcomingMatches(): NetworkResult<List<RemoteMatchUpcoming>>

    suspend fun getRecentlyMatch(): NetworkResult<RemoteRecentlyMatch>
}