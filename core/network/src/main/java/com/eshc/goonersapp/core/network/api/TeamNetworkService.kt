package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.BaseResponse
import com.eshc.goonersapp.core.network.model.team.RemoteTeamDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val TEAM_BASE_URL = "/apis/team"
interface TeamNetworkService {

    @GET(value = "$TEAM_BASE_URL/detail")
    suspend fun getTeamDetail(
        @Query("teamId") teamId : Int = 2
    ) : Response<BaseResponse<RemoteTeamDetail>>

}