package com.eshc.goonersapp.core.network.di

import com.eshc.goonersapp.core.network.GnrRemoteDataSource
import com.eshc.goonersapp.core.network.remote.GnrRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindGnrRemoteDataSource(
        gnrRemoteDataSource: GnrRemoteDataSourceImpl
    ): GnrRemoteDataSource
}