package com.eshc.goonersapp.core.network.di

import com.eshc.goonersapp.core.network.BuildConfig
import com.eshc.goonersapp.core.network.api.MatchNetworkService
import com.eshc.goonersapp.core.network.api.PlayerNetworkService
import com.eshc.goonersapp.core.network.api.TeamNetworkService
import com.eshc.goonersapp.core.network.api.UserNetworkService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.socket.client.IO
import io.socket.client.Socket
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.net.URI
import javax.inject.Singleton

private const val GNR_BASE_URL = BuildConfig.GNR_BASE_URL

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
        )
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        networkJson: Json,
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(GNR_BASE_URL)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .client(client)
        .build()


    @Singleton
    @Provides
    fun providePlayerNetworkService(retrofit: Retrofit): PlayerNetworkService =
        retrofit.create(
            PlayerNetworkService::class.java
        )

    @Singleton
    @Provides
    fun provideMatchNetworkService(retrofit: Retrofit): MatchNetworkService =
        retrofit.create(
            MatchNetworkService::class.java
        )

    @Singleton
    @Provides
    fun provideTeamNetworkService(retrofit: Retrofit): TeamNetworkService =
        retrofit.create(
            TeamNetworkService::class.java
        )

    @Singleton
    @Provides
    fun provideUserNetworkService(retrofit: Retrofit): UserNetworkService =
        retrofit.create(
            UserNetworkService::class.java
        )

    @Singleton
    @Provides
    fun provideChatSocket(): Socket = IO.socket(
        URI.create(GNR_BASE_URL),
        IO.Options.builder().setPath("/socket")
            .setReconnectionAttempts(5)
            .setReconnectionDelay(1_000)
            .setReconnectionDelayMax(5_000)
            .setTransports(arrayOf("websocket"))
            .setTimeout(20_000).build()
    )
}