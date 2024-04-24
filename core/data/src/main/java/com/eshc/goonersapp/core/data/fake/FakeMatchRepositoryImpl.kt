package com.eshc.goonersapp.core.data.fake

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchRecently
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.fake.FakeMatchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeMatchRepositoryImpl @Inject constructor(
    private val fakeMatchDataSource: FakeMatchDataSource
) : MatchRepository {

    override fun getMatch(match: Int): Flow<DataResult<Match>> = flow {
        val result = fakeMatchDataSource
            .getMatch(match)
            .toDataResult { remote -> remote.match.toModel() }

        emit(result)
    }

    override fun getMatchInformation(
        match: Int,
        season: Int,
        opponent: Int,
    ): Flow<DataResult<MatchInformation>> = flow {
        val result = fakeMatchDataSource
            .getMatchInformation(
                matchId = match,
                seasonId = season,
                opponentId = opponent
            ).toDataResult { remote -> remote.toModel() }

        emit(result)
    }

    override fun getMatchesBySeason(season: String): Flow<DataResult<List<Match>>> = flow {
        val result = fakeMatchDataSource
            .getMatchesBySeason(seasonId = season.toInt())
            .toDataResult { remote -> remote.map { response -> response.toModel() } }

        emit(result)
    }

    override fun getUpcomingMatches(): Flow<DataResult<List<Match>>> = flow {
        val result = fakeMatchDataSource
            .getUpcomingMatches()
            .toDataResult { remote -> remote.map { response -> response.toModel() } }

        emit(result)
    }

    override fun getRecentlyMatch(): Flow<DataResult<MatchRecently>> = flow {
        val result = fakeMatchDataSource
            .getRecentlyMatch()
            .toDataResult { remote -> remote.toModel() }

        emit(result)
    }

}