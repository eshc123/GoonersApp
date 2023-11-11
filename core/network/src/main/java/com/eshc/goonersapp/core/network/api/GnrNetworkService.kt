package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.RemotePlayer
import retrofit2.http.GET

interface GnrNetworkService {

    @GET(value = "/players")
    suspend fun getPlayers() : List<RemotePlayer>
}
