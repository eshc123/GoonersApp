package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchData
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchNetworkDataSource: MatchNetworkDataSource
) : MatchRepository {

    override fun getMatch(matchId: Int): Flow<DataResult<MatchData>> = flow {
        val result = matchNetworkDataSource
            .getMatch(matchId)
            .toDataResult { remote -> remote.toModel() }

        emit(result)
    }

    override fun getMatchInformation(
        match: Int,
        season: Int,
        opponent: Int
    ): Flow<DataResult<MatchInformation>> = flow {
        val result = matchNetworkDataSource
            .getMatchInformation(match, season, opponent)
            .toDataResult { remote -> remote.toModel() }

        emit(result)
    }

    override fun getMatchesBySeason(seasonId : Int): Flow<DataResult<List<Match>>> = flow {
        val result = matchNetworkDataSource
            .getMatchesBySeason(seasonId)
            .toDataResult { remote -> remote.map { response -> response.toModel() } }

        emit(result)
    }

    override fun getUpcomingMatches(): Flow<DataResult<List<Match>>> = flow {
        val result = matchNetworkDataSource
            .getUpcomingMatches()
            .toDataResult { remote -> remote.map { response -> response.toModel() } }

        emit(result)
    }

    override fun getRecentlyMatch(): Flow<DataResult<MatchData>> = flow {
        val result = matchNetworkDataSource
            .getRecentlyMatch()
            .toDataResult { remote -> remote.toModel() }

        emit(result)
    }

    override fun getMatchLineup(matchId: Int): Flow<DataResult<MatchLineup>> = flow {
        val result = matchNetworkDataSource
            .getMatchLineup(matchId)
            .toDataResult { remote -> remote.toModel() }

        emit(result)
    }
}