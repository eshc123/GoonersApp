package com.eshc.goonersapp.core.database.dao

import androidx.room.Dao
import androidx.room.Query
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
    fun getPlayers() : Flow<List<PlayerEntity>>
}