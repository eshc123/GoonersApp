package com.eshc.goonersapp.core.network.remote

import android.util.Log
import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.api.MatchNetworkService
import com.eshc.goonersapp.core.network.api.PlayerNetworkService
import com.eshc.goonersapp.core.network.model.RemoteMatch
import com.eshc.goonersapp.core.network.model.RemotePlayer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchNetworkDataSourceImpl @Inject constructor(
    private val matchNetworkService: MatchNetworkService
) : MatchNetworkDataSource {

    override suspend fun getMatchesByMonth(startDate : String, endDate : String): List<RemoteMatch> {
        return try {
            val response = matchNetworkService.getMatchesByMonth(startDate = startDate, endDate = endDate)
            if(response.isSuccessful){
                response.body()?.result ?: emptyList()
            }else emptyList()
        }catch (e:Exception){
            Log.d("123123",e.toString())
            emptyList()
        }
    }
}
