package com.eshc.goonersapp.core.network.remote

import android.util.Log
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.api.PlayerNetworkService
import com.eshc.goonersapp.core.network.model.RemotePlayer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerNetworkDataSourceImpl @Inject constructor(
    private val playerNetworkService: PlayerNetworkService
) : PlayerNetworkDataSource {


    override suspend fun getPlayerList(): List<RemotePlayer> {
        return try {
            val response = playerNetworkService.getPlayers()
            if(response.isSuccessful){
                response.body()?.result ?: emptyList()
            }else emptyList()
        }catch (e:Exception){
            emptyList()
        }
    }

    override suspend fun getPlayerDetail(playerId: Int): RemotePlayer {
        return try {
            val response = playerNetworkService.getPlayerDetail(playerId = playerId)
            if(response.isSuccessful){
                response.body()?.result ?: RemotePlayer(-1)
            }else RemotePlayer(-1)
        }catch (e:Exception){
            RemotePlayer(-1)
        }
    }

}
