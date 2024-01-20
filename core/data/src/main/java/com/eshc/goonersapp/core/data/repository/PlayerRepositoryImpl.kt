package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerNetworkDataSource: PlayerNetworkDataSource
) : PlayerRepository {
    override fun getPlayers(): Flow<List<Player>> = flow {
        emit(playerNetworkDataSource.getPlayerList().map { it.toModel() })
    }

    override fun getPlayerDetail(playerId: Int): Flow<Player> = flow {
        emit(playerNetworkDataSource.getPlayerDetail(playerId).toModel())
    }
}