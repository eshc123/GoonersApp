package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.api.PlayerNetworkService
import com.eshc.goonersapp.core.network.api.SeasonNetworkService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

/**
 * Created By Jung SeokJoon
 *
 * [RemotePlayerApiTest]
 *  - Gooners api Player local unit test
 *  - this test is real network api call test
 */
class RemotePlayerApiTest {
    private val responseOkCode = 200
    private val baseUrl = BuildConfig.GNR_BASE_URL
    private val networkJson = Json { ignoreUnknownKeys = true }

    private lateinit var okHttpClient: OkHttpClient
    private lateinit var retrofit: Retrofit
    private lateinit var playerApi: PlayerNetworkService

    @Before
    fun initNetworkInstances() {
        okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()

        retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType())
            )
            .client(okHttpClient)
            .build()

        playerApi = retrofit.create(PlayerNetworkService::class.java)
    }


    /**
     * (Test Passed)
     *
     * Player List network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_PLAYER_LIST_RESPONSE_IS_OK() = runBlocking {
        val response = playerApi.getPlayers()
        assertEquals(responseOkCode, response.code())
        println(response.body())
    }

    /**
     * (Test Passed)
     *
     * Player Detail network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_PLAYER_DETAIL_RESPONSE_IS_OK() = runBlocking {
        val response = playerApi.getPlayerDetail(playerId = 1494446)
        assertEquals(responseOkCode, response.code())
        println(response.body())
    }
}