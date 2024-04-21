package com.eshc.goonersapp.core.network

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
 * [RemoteSeasonApiTest]
 *  - Gooners api Season local unit test
 *  - this test is real network api call test
 */
class RemoteSeasonApiTest {
    private val responseOkCode = 200
    private val baseUrl = BuildConfig.GNR_BASE_URL
    private val networkJson = Json { ignoreUnknownKeys = true }

    private lateinit var okHttpClient: OkHttpClient
    private lateinit var retrofit: Retrofit
    private lateinit var seasonApi: SeasonNetworkService

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

        seasonApi = retrofit.create(SeasonNetworkService::class.java)
    }


    /**
     * (Test Passed)
     *
     * Season List network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_SEASON_LIST_RESPONSE_IS_OK() = runBlocking {
        val response = seasonApi.getSeasonListByTeam()
        assertEquals(responseOkCode, response.code())
        println(response.body())
    }

    /**
     * (Test Passed)
     *
     * League List As Current Season By Team network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_LEAGUE_LIST_AS_CURRENT_SEASON_BY_TEAM_RESPONSE_IS_OK() = runBlocking {
        val response = seasonApi.getLeagueListAsCurrentSeasonByTeam()
        assertEquals(responseOkCode, response.code())
        println(response.body())
    }

    /**
     * (Test Passed)
     *
     * Preview Rank List By Team And Season network communication test
     *  - when response code is 200, Test Passed
     */
    @Test
    fun test_GET_PREVIEW_RANK_LIST_BY_TEAM_AND_SEASON_RESPONSE_IS_OK() = runBlocking {
        val response = seasonApi.getPreviewRankListByTeamAndSeason()
        assertEquals(responseOkCode, response.code())
        println(response.body())
    }


}