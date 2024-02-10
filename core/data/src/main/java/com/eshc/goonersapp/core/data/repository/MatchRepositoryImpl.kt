package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toEntity
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.database.dao.PlayerDao
import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.remote.MatchNetworkDataSourceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchNetworkDataSource: MatchNetworkDataSource
) : MatchRepository {

    override fun getMatchesByMonth(startDate : String, endDate : String): Flow<List<Match>> = flow {
        emit(matchNetworkDataSource.getMatchesByMonth(startDate,endDate).map { it.toModel() })
    }
}