package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.api.MatchNetworkService
import com.eshc.goonersapp.core.network.model.RemoteMatch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchNetworkDataSourceImpl @Inject constructor(
    private val matchNetworkService: MatchNetworkService
) : MatchNetworkDataSource {

    override suspend fun getMatchesBySeason(season : String): List<RemoteMatch> {
        return try {
            val response = matchNetworkService.getMatchesBySeason(season = season)
            if(response.isSuccessful){
                response.body()?.result ?: emptyList()
            }else emptyList()
        }catch (e:Exception){
            emptyList()
        }
    }
}
