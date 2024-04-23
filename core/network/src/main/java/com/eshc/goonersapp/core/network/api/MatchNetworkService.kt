package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.BaseResponse
import com.eshc.goonersapp.core.network.model.match.RemoteMatchData
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteRecentlyMatch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val MATCH_BASE_URL = "/apis/match"
interface MatchNetworkService {

    @GET(value = "$MATCH_BASE_URL/{matchId}")
    suspend fun getMatch(
        @Path("matchId") matchId: Int
    ) : Response<BaseResponse<RemoteMatchData>>

    @GET(value = "$MATCH_BASE_URL/information")
    suspend fun getMatchInformation(
        @Query("matchId") matchId: Int,
        @Query("seasonId") seasonId: Int,
        @Query("teamId") teamId: Int = 19,
        @Query("opponentId") opponentId: Int
    ) : Response<BaseResponse<RemoteMatchInformation>>

    @GET(value = "$MATCH_BASE_URL/team")
    suspend fun getMatchesBySeason(
        @Query("teamId") teamId : Int = 19,
        @Query("seasonId") seasonId : Int
    ) : Response<BaseResponse<List<RemoteMatch>>>

    @GET(value = "$MATCH_BASE_URL/team/upcoming")
    suspend fun getUpcomingMatches(
        @Query("teamId") teamId : Int = 19
    ) : Response<BaseResponse<List<RemoteMatch>>>

    @GET(value = "$MATCH_BASE_URL/team/recently")
    suspend fun getRecentlyMatch(
        @Query("teamId") teamId : Int = 19
    ) : Response<BaseResponse<RemoteRecentlyMatch>>
}