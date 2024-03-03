package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchNetworkDataSource: MatchNetworkDataSource
) : MatchRepository {

    override fun getMatchesBySeason(season : String): Flow<DataResult<List<Match>>> = flow {
        emit(
            matchNetworkDataSource.getMatchesBySeason(season).toDataResult {
                it.map { remoteMatch ->
                    remoteMatch.toModel()
                }
            }
        )
    }

    override fun getUpcomingMatches(): Flow<DataResult<List<Match>>> = flow {
        emit(
            matchNetworkDataSource.getUpcomingMatches().toDataResult {
                it.map { remoteMatch ->
                    remoteMatch.toModel()
                }
            }
        )
    }

    override fun getRecentlyMatch(): Flow<DataResult<Match>> = flow {
        emit(
            matchNetworkDataSource.getRecentlyMatch().toDataResult {
                it.match.toModel()
            }
        )
    }
}