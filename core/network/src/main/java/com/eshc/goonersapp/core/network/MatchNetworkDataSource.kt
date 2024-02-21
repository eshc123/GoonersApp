package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.RemoteMatch

interface MatchNetworkDataSource {

    suspend fun getMatchesBySeason(season : String) : List<RemoteMatch>
}