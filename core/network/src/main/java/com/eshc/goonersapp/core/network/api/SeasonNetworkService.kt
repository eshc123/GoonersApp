package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.BaseResponse
import com.eshc.goonersapp.core.network.model.season.RemoteLeague
import com.eshc.goonersapp.core.network.model.season.RemoteRank
import com.eshc.goonersapp.core.network.model.season.RemoteSeason
import com.eshc.goonersapp.core.network.model.team.RemoteTeamDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val SEASON_BASE_URL = "/apis/season"
interface SeasonNetworkService {

    @GET(value = "$SEASON_BASE_URL/list")
    suspend fun getSeasonListByTeam(
        @Query("teamId") teamId : Int = 19
    ) : Response<BaseResponse<List<RemoteSeason>>>

    @GET(value = "$SEASON_BASE_URL/league")
    suspend fun getLeagueListAsCurrentSeasonByTeam(
        @Query("teamId") teamId : Int = 19
    ) : Response<BaseResponse<List<RemoteLeague>>>

    @GET(value = "$SEASON_BASE_URL/rank")
    suspend fun getPreviewRankListByTeamAndSeason(
        @Query("teamId") teamId : Int = 19,
        @Query("seasonId") seasonId : Int = 21646
    ) : Response<BaseResponse<List<RemoteRank>>>

}