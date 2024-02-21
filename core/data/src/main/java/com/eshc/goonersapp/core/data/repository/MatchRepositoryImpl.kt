package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchNetworkDataSource: MatchNetworkDataSource
) : MatchRepository {

    override fun getMatchesBySeason(season : String): Flow<List<Match>> = flow {
        emit(matchNetworkDataSource.getMatchesBySeason(season).map { it.toModel() })
    }
}