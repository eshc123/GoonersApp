package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.api.MatchNetworkService
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
 * Api Match local unit test
 */
class MatchApiUnitTest {
    private val responseOkCode = 200
    private val baseUrl = BuildConfig.GNR_BASE_URL
    private val networkJson = Json { ignoreUnknownKeys = true }

    private lateinit var okHttpClient: OkHttpClient
    private lateinit var retrofit: Retrofit
    private lateinit var matchApi: MatchNetworkService

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

        matchApi = retrofit.create(MatchNetworkService::class.java)
    }


    /**
     * (Test Passed)
     *
     * Match network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_MATCH_RESPONSE_IS_OK() = runBlocking {
        val response = matchApi.getMatch(matchId = 18842551)
        assertEquals(responseOkCode, response.code())
    }


    /**
     * (Test Passed)
     *
     * Match Information network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_MATCH_INFORMATION_RESPONSE_IS_OK() = runBlocking {
        val response = matchApi.getMatchInformation(matchId = 18842551, seasonId = 2024, opponentId = 236)
        assertEquals(responseOkCode, response.code())
    }


    /**
     * (Test not Passed)
     *
     * TODO("need to check api urls")
     *
     * Match team by season Information network communication test
     *  - when response code is 200, Test Passed,
     *
     * actual response
     *  - code : "err01"
     *  - result : { }
     */
    @Test
    fun test_GET_TEAM_BY_SEASON_RESPONSE_IS_OK() = runBlocking {
        val response = matchApi.getMatchesBySeason(seasonId = 2023)

        assertEquals(responseOkCode, response.code())
        println(response.body())
    }


    /**
     * (Test Passed)
     *
     * Match Upcoming network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_MATCH_BY_UPCOMING_RESPONSE_STATUS_IS_OK() = runBlocking {
        val response = matchApi.getUpcomingMatches()
        assertEquals(responseOkCode, response.code())
    }

    /**
     * (Test Passed)
     *
     * Match Recently network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_RECENTLY_MATCH_RESPONSE_STATUS_IS_OK() = runBlocking {
        val response = matchApi.getRecentlyMatch()
        assertEquals(responseOkCode, response.code())
    }
}