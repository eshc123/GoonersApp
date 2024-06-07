package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toEntity
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.database.PlayerLocalDataSource
import com.eshc.goonersapp.core.database.database.dao.PlayerDao
import com.eshc.goonersapp.core.database.model.DatabaseResult
import com.eshc.goonersapp.core.database.model.onComplete
import com.eshc.goonersapp.core.database.model.onFailure
import com.eshc.goonersapp.core.database.model.onSuccess
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.core.domain.model.player.PlayerList
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.player.RemotePlayerList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerNetworkDataSource: PlayerNetworkDataSource,
    private val playerLocalDataSource: PlayerLocalDataSource
) : PlayerRepository {
    override fun getPlayers(): Flow<DataResult<PlayerList>> = flow {
        emit(
            playerNetworkDataSource.getPlayerList().toDataResult {
                it.toModel()
            }
        )
    }

    override fun getPlayerDetail(playerId: Int): Flow<Player> = flow {
        playerLocalDataSource.getPlayerEntity(playerId)
            .onSuccess {
                emit(it.toModel())
            }.onFailure {
                when (val result = playerNetworkDataSource.getPlayerDetail(playerId)) {
                    is NetworkResult.Success -> {
                        result.data.let { remotePlayer ->
                            playerLocalDataSource.upsertPlayer(remotePlayer.toEntity())
                                .onComplete {
                                    emit(remotePlayer.toModel())
                                }
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