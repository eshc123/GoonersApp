package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.GnrRemoteDataSource
import com.eshc.goonersapp.core.network.api.GnrNetworkService
import com.eshc.goonersapp.core.network.model.RemotePlayer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GnrRemoteDataSourceImpl @Inject constructor(
    private val gnrNetworkService: GnrNetworkService
) : GnrRemoteDataSource {


    override suspend fun getPlayers(): List<RemotePlayer> {
        try {
            return gnrNetworkService.getPlayers()
        }catch (e:Exception){
            return emptyList()
        }
    }

}