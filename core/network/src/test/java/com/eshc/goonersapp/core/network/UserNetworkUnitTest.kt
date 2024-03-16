package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.BuildConfig.GNR_BASE_URL
import com.eshc.goonersapp.core.network.api.UserNetworkService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.junit.Before
import retrofit2.Retrofit

class UserNetworkUnitTest {
    private lateinit var userNetworkService: UserNetworkService

    @Before
    fun init() {
        val okHttpClient = OkHttpClient.Builder().build()

        val networkJson = Json {
            ignoreUnknownKeys = true
        }

        userNetworkService = Retrofit.Builder()
            .baseUrl(GNR_BASE_URL)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .client(okHttpClient)
            .build().create(UserNetworkService::class.java)

    }

}