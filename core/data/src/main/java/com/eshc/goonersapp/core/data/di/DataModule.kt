package com.eshc.goonersapp.core.data.di

import com.eshc.goonersapp.core.data.repository.ChatRepositoryImpl
import com.eshc.goonersapp.core.data.repository.MatchRepositoryImpl
import com.eshc.goonersapp.core.data.repository.PlayerRepositoryImpl
import com.eshc.goonersapp.core.data.repository.SeasonRepositoryImpl
import com.eshc.goonersapp.core.data.repository.TeamRepositoryImpl
import com.eshc.goonersapp.core.data.repository.UserRepositoryImpl
import com.eshc.goonersapp.core.data.util.NetworkConnectivityManager
import com.eshc.goonersapp.core.data.util.NetworkConnectivityManagerImpl
import com.eshc.goonersapp.core.domain.repository.ChatRepository
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import com.eshc.goonersapp.core.domain.repository.SeasonRepository
import com.eshc.goonersapp.core.domain.repository.TeamRepository
import com.eshc.goonersapp.core.domain.repository.UserRepository
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

    @Binds
    abstract fun bindsTeamRepository(
        teamRepository: TeamRepositoryImpl,
    ): TeamRepository

    @Binds
    abstract fun bindsSeasonRepository(
        seasonRepository: SeasonRepositoryImpl
    ): SeasonRepository

    @Binds
    abstract fun bindsUserRepository(
        userRepository: UserRepositoryImpl,
    ): UserRepository

    @Binds
    internal abstract fun bindsNetworkConnectivityManager(
        networkMonitor: NetworkConnectivityManagerImpl,
    ): NetworkConnectivityManager
}