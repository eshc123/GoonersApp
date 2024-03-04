package com.eshc.goonersapp.core.database.datasource

import com.eshc.goonersapp.core.database.PlayerLocalDataSource
import com.eshc.goonersapp.core.database.database.dao.PlayerDao
import com.eshc.goonersapp.core.database.model.DatabaseResult
import com.eshc.goonersapp.core.database.model.PlayerEntity
import com.eshc.goonersapp.core.database.model.handleDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerLocalDataSourceImpl  @Inject constructor(
    private val playerDao: PlayerDao
) : PlayerLocalDataSource {
    override suspend fun getPlayerEntity(playerId: Int): DatabaseResult<PlayerEntity> {
        return handleDatabase{
            playerDao.getPlayerEntity(playerId)
        }

    }

    override suspend fun upsertPlayer(entity: PlayerEntity): DatabaseResult<Unit> {
        return handleDatabase{
            playerDao.upsertPlayer(entity)
        }
    }

}
