package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.team.TeamDetail
import com.eshc.goonersapp.core.domain.repository.TeamRepository
import com.eshc.goonersapp.core.network.TeamNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamNetworkDataSource: TeamNetworkDataSource
) : TeamRepository {
    override fun getTeamDetail(): Flow<TeamDetail> = flow {
        when(val result = teamNetworkDataSource.getTeamDetail()){
            is NetworkResult.Success -> {
                emit(result.data.toModel())
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