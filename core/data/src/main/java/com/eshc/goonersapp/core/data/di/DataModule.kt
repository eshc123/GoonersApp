package com.eshc.goonersapp.core.data.di

import com.eshc.goonersapp.core.data.repository.PlayerRepositoryImpl
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsPlayerRepository(
        playerRepository: PlayerRepositoryImpl,
    ): PlayerRepository
}