package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.SeasonNetworkDataSource
import com.eshc.goonersapp.core.network.api.PlayerNetworkService
import com.eshc.goonersapp.core.network.api.SeasonNetworkService
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.handleApi
import com.eshc.goonersapp.core.network.model.player.RemotePlayer
import com.eshc.goonersapp.core.network.model.season.RemoteLeague
import com.eshc.goonersapp.core.network.model.season.RemoteRank
import com.eshc.goonersapp.core.network.model.season.RemoteSeason
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeasonNetworkDataSourceImpl @Inject constructor(
    private val seasonNetworkService: SeasonNetworkService
) : SeasonNetworkDataSource {

    override suspend fun getSeasonListByTeam(teamId: Int): NetworkResult<List<RemoteSeason>> {
        return handleApi {
            seasonNetworkService.getSeasonListByTeam(teamId)
        }
    }

    override suspend fun getLeagueListAsCurrentSeasonByTeam(teamId: Int): NetworkResult<List<RemoteLeague>> {
        return handleApi {
            seasonNetworkService.getLeagueListAsCurrentSeasonByTeam(teamId)
        }
    }

    override suspend fun getPreviewRankListByTeamAndSeason(
        teamId: Int,
        seasonId: Int
    ): NetworkResult<List<RemoteRank>> {
        return handleApi {
            seasonNetworkService.getPreviewRankListByTeamAndSeason(teamId,seasonId)
        }
    }
}
