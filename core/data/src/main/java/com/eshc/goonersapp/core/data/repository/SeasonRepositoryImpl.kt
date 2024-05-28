package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.season.League
import com.eshc.goonersapp.core.domain.model.season.Rank
import com.eshc.goonersapp.core.domain.model.season.Season
import com.eshc.goonersapp.core.domain.repository.SeasonRepository
import com.eshc.goonersapp.core.network.SeasonNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SeasonRepositoryImpl @Inject constructor(
    private val seasonNetworkDataSource: SeasonNetworkDataSource
): SeasonRepository {
    override suspend fun getSeasonListByTeam(teamId: Int): Flow<DataResult<List<Season>>> = flow {
        val result = seasonNetworkDataSource
            .getSeasonListByTeam(teamId)
            .toDataResult { remote -> remote.map { it.toModel() } }

        emit(result)
    }

    override suspend fun getLeagueListAsCurrentSeasonByTeam(
        teamId: Int
    ): Flow<DataResult<List<League>>> = flow {
        val result = seasonNetworkDataSource
            .getLeagueListAsCurrentSeasonByTeam(teamId)
            .toDataResult { remote -> remote.map { it.toModel() } }

        emit(result)
    }

    override suspend fun getPreviewRankListByTeamAndSeason(
        teamId: Int,
        seasonId: Int,
    ): Flow<DataResult<List<Rank>>> = flow {
        val result = seasonNetworkDataSource
            .getPreviewRankListByTeamAndSeason(teamId, seasonId)
            .toDataResult { remote -> remote.map { it.toModel() } }

        emit(result)
    }

}