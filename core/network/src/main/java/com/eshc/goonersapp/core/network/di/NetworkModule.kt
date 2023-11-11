package com.eshc.goonersapp.core.network.di

import com.eshc.goonersapp.core.network.BuildConfig
import com.eshc.goonersapp.core.network.api.GnrNetworkService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
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
    ) : Retrofit = Retrofit.Builder()
            .baseUrl(GNR_BASE_URL)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .client(client)
            .build()


    @Singleton
    @Provides
    fun provideGnrNetworkService(retrofit: Retrofit) : GnrNetworkService =
        retrofit.create(
            GnrNetworkService::class.java
        )
}