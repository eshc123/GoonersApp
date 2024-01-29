package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toEntity
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.database.dao.PlayerDao
import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerNetworkDataSource: PlayerNetworkDataSource,
    private val playerDao: PlayerDao
) : PlayerRepository {
    override fun getPlayers(): Flow<List<Player>> = flow {
        emit(playerNetworkDataSource.getPlayerList().map { it.toModel() })
    }

    override fun getPlayerDetail(playerId: Int): Flow<Player> = flow {
        playerDao.getPlayerEntity(playerId).let {  playerEntity ->
            if(playerEntity != null) emit(playerEntity.toModel())
            else {
                playerNetworkDataSource.getPlayerDetail(playerId).let { remotePlayer ->
                    playerDao.upsertPlayer(remotePlayer.toEntity())
                    emit(remotePlayer.toModel())
                }
            }
        }
    }
}