package com.eshc.goonersapp.core.database.di

import com.eshc.goonersapp.core.database.database.GnrDatabase
import com.eshc.goonersapp.core.database.database.dao.PlayerDao
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