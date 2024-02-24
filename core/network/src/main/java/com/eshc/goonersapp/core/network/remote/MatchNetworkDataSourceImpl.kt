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

    override suspend fun getUpcomingMatches(): List<RemoteMatch> {
        return try {
            val response = matchNetworkService.getUpcomingMatches()
            if(response.isSuccessful){
                response.body()?.result ?: emptyList()
            }else emptyList()
        }catch (e:Exception){
            emptyList()
        }
    }

    override suspend fun getRecentlyMatch(): RemoteMatch {
        return try {
            val response = matchNetworkService.getRecentlyMatch()
            if(response.isSuccessful){
                response.body()?.result?.match ?: RemoteMatch(0)
            }else RemoteMatch(0)
        }catch (e:Exception){
            RemoteMatch(0)
        }
    }
}
