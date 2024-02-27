package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toEntity
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.database.dao.PlayerDao
import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerNetworkDataSource: PlayerNetworkDataSource,
    private val playerDao: PlayerDao
) : PlayerRepository {
    override fun getPlayers(): Flow<List<Player>> = flow {
        when(val result = playerNetworkDataSource.getPlayerList()){
            is NetworkResult.Success -> {
                emit(result.data.map { it.toModel() })
            }
            is NetworkResult.Error -> {
                throw Exception(result.message)
            }
            is NetworkResult.Exception -> {
                throw result.e
            }
        }
    }

    override fun getPlayerDetail(playerId: Int): Flow<Player> = flow {
        playerDao.getPlayerEntity(playerId).let {  playerEntity ->
            if(playerEntity != null) emit(playerEntity.toModel())
            else {
                when(val result = playerNetworkDataSource.getPlayerDetail(playerId)){
                    is NetworkResult.Success -> {
                        result.data.let { remotePlayer ->
                            playerDao.upsertPlayer(remotePlayer.toEntity())
                            emit(remotePlayer.toModel())
                        }
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
    }
}