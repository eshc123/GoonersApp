package com.eshc.goonersapp.core.database

import com.eshc.goonersapp.core.database.model.DatabaseResult
import com.eshc.goonersapp.core.database.model.PlayerEntity

interface PlayerLocalDataSource {

    suspend fun getPlayerEntity(playerId : Int) : DatabaseResult<PlayerEntity>

    suspend fun upsertPlayer(entity: PlayerEntity)  : DatabaseResult<Unit>
}