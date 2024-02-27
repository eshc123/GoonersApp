package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteRecentlyMatch

interface MatchNetworkDataSource {

    suspend fun getMatchesBySeason(season : String) : NetworkResult<List<RemoteMatch>>

    suspend fun getUpcomingMatches() : NetworkResult<List<RemoteMatch>>

    suspend fun getRecentlyMatch() : NetworkResult<RemoteRecentlyMatch>
}