package com.eshc.goonersapp.core.data.di

import com.eshc.goonersapp.core.data.repository.ChatRepositoryImpl
import com.eshc.goonersapp.core.data.repository.MatchRepositoryImpl
import com.eshc.goonersapp.core.data.repository.PlayerRepositoryImpl
import com.eshc.goonersapp.core.domain.repository.ChatRepository
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsPlayerRepository(
        playerRepository: PlayerRepositoryImpl,
    ): PlayerRepository

    @Binds
    abstract fun bindsMatchRepository(
        matchRepository: MatchRepositoryImpl,
    ): MatchRepository

    @Binds
    abstract fun bindsChatRepository(
        chatRepository: ChatRepositoryImpl,
    ): ChatRepository
}