package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.RemotePlayer
import retrofit2.http.GET

const val PLAYER_BASE_URL = "/apis/player"
interface PlayerNetworkService {

    @GET(value = "$PLAYER_BASE_URL/team")
    suspend fun getPlayers() : List<RemotePlayer>

    @GET(value = "$PLAYER_BASE_URL/detail")
    suspend fun getPlayerDetail() :RemotePlayer
}
