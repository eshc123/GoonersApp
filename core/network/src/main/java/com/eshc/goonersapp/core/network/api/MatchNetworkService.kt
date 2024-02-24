package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.BaseResponse
import com.eshc.goonersapp.core.network.model.RemoteMatch
import com.eshc.goonersapp.core.network.model.RemoteRecentlyMatch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val MATCH_BASE_URL = "/apis/match"
interface MatchNetworkService {

    @GET(value = "$MATCH_BASE_URL/team")
    suspend fun getMatchesBySeason(
        @Query("teamId") teamId : Int = 2,
        @Query("season") season : String
    ) : Response<BaseResponse<List<RemoteMatch>>>

    @GET(value = "$MATCH_BASE_URL/team/upcoming")
    suspend fun getUpcomingMatches(
        @Query("teamId") teamId : Int = 2,
    ) : Response<BaseResponse<List<RemoteMatch>>>

    @GET(value = "$MATCH_BASE_URL/team/recently")
    suspend fun getRecentlyMatch(
        @Query("teamId") teamId : Int = 2,
    ) : Response<BaseResponse<RemoteRecentlyMatch>>
}
