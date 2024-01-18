package com.eshc.goonersapp.core.database

import com.eshc.goonersapp.core.database.dao.PlayerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun providesPlayerDao(
        database: GnrDatabase,
    ): PlayerDao = database.playerDao()
}