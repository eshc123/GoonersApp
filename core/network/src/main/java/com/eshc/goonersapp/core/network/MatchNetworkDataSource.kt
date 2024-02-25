package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.match.RemoteMatch

interface MatchNetworkDataSource {

    suspend fun getMatchesBySeason(season : String) : List<RemoteMatch>

    suspend fun getUpcomingMatches() : List<RemoteMatch>

    suspend fun getRecentlyMatch() : RemoteMatch
}