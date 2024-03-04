package com.eshc.goonersapp.core.database.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.eshc.goonersapp.core.database.model.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query(
        value = """
            SELECT *
            FROM player
        """
    )
    fun getPlayerEntities() : Flow<List<PlayerEntity>>

    @Query(
        value = """
            SELECT *
            FROM player
            WHERE id = :playerId
        """
    )
    suspend fun getPlayerEntity(playerId : Int) : PlayerEntity?


    @Upsert
    suspend fun upsertPlayer(entity: PlayerEntity)
}