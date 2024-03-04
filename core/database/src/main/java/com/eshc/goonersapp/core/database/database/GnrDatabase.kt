package com.eshc.goonersapp.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eshc.goonersapp.core.database.database.dao.PlayerDao
import com.eshc.goonersapp.core.database.model.PlayerEntity

@Database(
    entities = [
        PlayerEntity::class
    ],
    version = 1
)
internal abstract class GnrDatabase : RoomDatabase() {
    abstract fun playerDao() : PlayerDao
}
