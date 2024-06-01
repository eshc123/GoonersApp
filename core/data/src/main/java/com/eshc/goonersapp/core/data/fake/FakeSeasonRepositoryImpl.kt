package com.eshc.goonersapp.core.data.fake

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.season.League
import com.eshc.goonersapp.core.domain.model.season.Rank
import com.eshc.goonersapp.core.domain.model.season.Season
import com.eshc.goonersapp.core.domain.repository.SeasonRepository
import com.eshc.goonersapp.core.network.fake.FakeSeasonDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeSeasonRepositoryImpl @Inject constructor(
    private val fakeSeasonDataSource: FakeSeasonDataSource
): SeasonRepository {
    override fun getSeasonListByTeam(teamId: Int): Flow<DataResult<List<Season>>> = flow {
        val result = fakeSeasonDataSource
            .getSeasonListByTeam(teamId)
            .toDataResult { remote -> remote.map { it.toModel() } }

        emit(result)
    }

    override fun getLeagueListAsCurrentSeasonByTeam(
        teamId: Int
    ): Flow<DataResult<List<League>>> = flow {
        val result = fakeSeasonDataSource
            .getLeagueListAsCurrentSeasonByTeam(teamId)
            .toDataResult { remote -> remote.map { it.toModel() } }

        emit(result)
    }

    override fun getPreviewRankListByTeamAndSeason(
        teamId: Int,
        seasonId: Int,
    ): Flow<DataResult<List<Rank>>> = flow {
        val result = fakeSeasonDataSource
            .getPreviewRankListByTeamAndSeason(teamId, seasonId)
            .toDataResult { remote -> remote.map { it.toModel() } }

        emit(result)
    }

}