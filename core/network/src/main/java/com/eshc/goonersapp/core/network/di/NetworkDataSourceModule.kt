package com.eshc.goonersapp.core.network.di

import com.eshc.goonersapp.core.network.ChatNetworkDataSource
import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.SeasonNetworkDataSource
import com.eshc.goonersapp.core.network.TeamNetworkDataSource
import com.eshc.goonersapp.core.network.UserNetworkDataSource
import com.eshc.goonersapp.core.network.remote.ChatNetworkDataSourceImpl
import com.eshc.goonersapp.core.network.remote.MatchNetworkDataSourceImpl
import com.eshc.goonersapp.core.network.remote.PlayerNetworkDataSourceImpl
import com.eshc.goonersapp.core.network.remote.SeasonNetworkDataSourceImpl
import com.eshc.goonersapp.core.network.remote.TeamNetworkDataSourceImpl
import com.eshc.goonersapp.core.network.remote.UserNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkDataSourceModule {

    @Binds
    abstract fun bindPlayerNetworkDataSource(
        gnrRemoteDataSource: PlayerNetworkDataSourceImpl
    ): PlayerNetworkDataSource

    @Binds
    abstract fun bindMatchNetworkDataSource(
        gnrRemoteDataSource: MatchNetworkDataSourceImpl
    ): MatchNetworkDataSource

    @Binds
    abstract fun bindChatNetworkDataSource(
        gnrRemoteDataSource: ChatNetworkDataSourceImpl
    ): ChatNetworkDataSource

    @Binds
    abstract fun bindTeamNetworkDataSource(
        gnrRemoteDataSource: TeamNetworkDataSourceImpl
    ): TeamNetworkDataSource

    @Binds
    abstract fun bindUserNetworkDataSource(
        gnrRemoteDataSource: UserNetworkDataSourceImpl
    ): UserNetworkDataSource

    @Binds
    abstract fun bindSeasonNetworkDataSource(
        gnrRemoteSeason: SeasonNetworkDataSourceImpl
    ): SeasonNetworkDataSource
}