package com.eshc.goonersapp.core.data.fake

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchData
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.fake.FakeMatchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeMatchRepositoryImpl @Inject constructor(
    private val fakeMatchDataSource: FakeMatchDataSource
) : MatchRepository {

    override fun getMatch(matchId: Int): Flow<DataResult<MatchData>> = flow {
        val result = fakeMatchDataSource
            .getMatch(matchId)
            .toDataResult { remote -> remote.toModel() }

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

    override fun getMatchesBySeason(seasonId: Int): Flow<DataResult<List<Match>>> = flow {
        val result = fakeMatchDataSource
            .getMatchesBySeason(seasonId = seasonId)
            .toDataResult { remote -> remote.map { response -> response.toModel() } }

        emit(result)
    }

    override fun getUpcomingMatches(): Flow<DataResult<List<Match>>> = flow {
        val result = fakeMatchDataSource
            .getUpcomingMatches()
            .toDataResult { remote -> remote.map { response -> response.toModel() } }

        emit(result)
    }

    override fun getRecentlyMatch(): Flow<DataResult<MatchData>> = flow {
        val result = fakeMatchDataSource
            .getRecentlyMatch()
            .toDataResult { remote -> remote.toModel() }

        emit(result)
    }

    override fun getMatchLineup(matchId: Int): Flow<DataResult<MatchLineup>> = flow {
        val result = fakeMatchDataSource
            .getMatchLineup(matchId)
            .toDataResult { remote -> remote.toModel() }

        emit(result)
    }

}