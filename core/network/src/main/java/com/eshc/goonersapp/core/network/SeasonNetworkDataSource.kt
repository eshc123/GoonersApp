package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.season.RemoteLeague
import com.eshc.goonersapp.core.network.model.season.RemoteRank
import com.eshc.goonersapp.core.network.model.season.RemoteSeason

interface SeasonNetworkDataSource {

    suspend fun getSeasonListByTeam(teamId : Int) : NetworkResult<List<RemoteSeason>>

    suspend fun getLeagueListAsCurrentSeasonByTeam(teamId : Int) : NetworkResult<List<RemoteLeague>>

    suspend fun getPreviewRankListByTeamAndSeason(teamId : Int,seasonId : Int) : NetworkResult<List<RemoteRank>>
}