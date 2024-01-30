package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.RemoteMatch
import com.eshc.goonersapp.core.network.model.RemotePlayer

interface MatchNetworkDataSource {

    suspend fun getMatchesByMonth(startDate : String, endDate : String) : List<RemoteMatch>
}