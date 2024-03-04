package com.eshc.goonersapp.core.database.di

import com.eshc.goonersapp.core.database.PlayerLocalDataSource
import com.eshc.goonersapp.core.database.datasource.PlayerLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindPlayerLocalDataSource(
        gnrLocalDataSource: PlayerLocalDataSourceImpl
    ): PlayerLocalDataSource
}