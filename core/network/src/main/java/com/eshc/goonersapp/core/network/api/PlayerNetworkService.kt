package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.BaseResponse
import com.eshc.goonersapp.core.network.model.player.RemotePlayer
import com.eshc.goonersapp.core.network.model.player.RemotePlayerList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val PLAYER_BASE_URL = "/apis/player"
interface PlayerNetworkService {

    @GET(value = "$PLAYER_BASE_URL/team/season")
    suspend fun getPlayers(
        @Query("teamId") teamId : Int = 19,
        @Query("seasonId") seasonId : Int = 21646,
        @Query("positionId") positionId : Int? = null,
        @Query("keyword") keyword : String? = null,
        @Query("page") page : Int? = null,
        @Query("size") size : Int? = null
    ) : Response<BaseResponse<RemotePlayerList>>

    @GET(value = "$PLAYER_BASE_URL/detail")
    suspend fun getPlayerDetail(
        @Query("teamId") teamId : Int = 19,
        @Query("playerId") playerId : Int
    ) : Response<BaseResponse<RemotePlayer>>
}
