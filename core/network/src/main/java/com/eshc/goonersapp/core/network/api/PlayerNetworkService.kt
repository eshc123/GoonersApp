package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.BaseResponse
import com.eshc.goonersapp.core.network.model.RemotePlayer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val PLAYER_BASE_URL = "/apis/player"
interface PlayerNetworkService {

    @GET(value = "$PLAYER_BASE_URL/team")
    suspend fun getPlayers(
        @Query("teamId") teamId : Int = 2
    ) : Response<BaseResponse<List<RemotePlayer>>>

    @GET(value = "$PLAYER_BASE_URL/detail")
    suspend fun getPlayerDetail(
        @Query("teamId") teamId : Int = 2,
        @Query("playerId") playerId : Int
    ) : Response<BaseResponse<RemotePlayer>>
}
