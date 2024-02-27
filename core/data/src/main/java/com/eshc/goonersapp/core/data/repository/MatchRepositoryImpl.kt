package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchNetworkDataSource: MatchNetworkDataSource
) : MatchRepository {

    override fun getMatchesBySeason(season : String): Flow<List<Match>> = flow {
        when(val result = matchNetworkDataSource.getMatchesBySeason(season)){
            is NetworkResult.Success -> {
                emit(result.data .map { it.toModel() })
            }
            is NetworkResult.Error -> {
                throw Exception(result.message)
            }
            is NetworkResult.Exception -> {
                throw result.e
            }
        }

    }

    override fun getUpcomingMatches(): Flow<List<Match>> = flow {
        when(val result = matchNetworkDataSource.getUpcomingMatches()){
            is NetworkResult.Success -> {
                emit(result.data .map { it.toModel() })
            }
            is NetworkResult.Error -> {
                throw Exception(result.message)
            }
            is NetworkResult.Exception -> {
                throw result.e
            }
        }
    }

    override fun getRecentlyMatch(): Flow<Match> = flow {
        when(val result = matchNetworkDataSource.getRecentlyMatch()){
            is NetworkResult.Success -> {
                emit(result.data.match.toModel())
            }
            is NetworkResult.Error -> {
                throw Exception(result.message)
            }
            is NetworkResult.Exception -> {
                throw result.e
            }
        }
    }
}