package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.fake.FakeMatchDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.match.LineUp
import com.eshc.goonersapp.core.network.model.match.RemoteMatchDetail
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created By KanuKim97
 *
 * [FakeMatchDataSourceTest]
 *  - [FakeMatchDataSource] test codes
 */
class FakeMatchDataSourceTest {
    private lateinit var fakeMatchDataSource: MatchNetworkDataSource

    @Before
    fun setUp() {
        fakeMatchDataSource = FakeMatchDataSource()
    }

    @Test
    fun fakeGetMatch() = runBlocking {
        when (val result = fakeMatchDataSource.getMatch(matchId = 38)) {
            is NetworkResult.Success -> {
                assertEquals(
                    listOf<RemoteMatchDetail>(),
                    result.data.matchDetail
                )
            }
            is NetworkResult.Error -> {
                assertEquals(404, result.code)
            }
            is NetworkResult.Exception -> { /* Nothing */ }
        }
    }


    @Test
    fun fakeGetMatchInformation() = runBlocking {
        val result = fakeMatchDataSource.getMatchInformation(
            matchId = 38,
            seasonId = 2024,
            opponentId = 236,
        )

        when (result) {
            is NetworkResult.Success -> {
                assertEquals(
                    listOf<LineUp>(),
                    result.data.lineUp
                )
            }
            is NetworkResult.Error -> {
                assertEquals(
                    404,
                    result.code
                )
            }
            is NetworkResult.Exception -> { /* Nothing */ }
        }
    }

    @Test
    fun fakeGetMatchesBySeason() = runBlocking {
        when (val result = fakeMatchDataSource.getMatchesBySeason(2025)) {
            is NetworkResult.Success -> {
                assertEquals(
                    listOf<RemoteMatch>(),
                    result.data
                )
            }
            is NetworkResult.Error -> {
                assertEquals(
                    404,
                    result.code
                )
            }
            is NetworkResult.Exception -> { /* Nothing */ }
        }
    }

    @Test
    fun fakeGetUpcomingMatches() = runBlocking {
        when (val result = fakeMatchDataSource.getUpcomingMatches()) {
            is NetworkResult.Success -> {
                assertEquals(
                    listOf<RemoteMatch>(),
                    result.data
                )
            }
            is NetworkResult.Error -> { /* Nothing */ }
            is NetworkResult.Exception -> { /* Nothing */ }
        }
    }

    @Test
    fun fakeGetRecentlyMatch() = runBlocking {
        when (val result = fakeMatchDataSource.getRecentlyMatch()) {
            is NetworkResult.Success -> {
                assertEquals(
                    listOf<RemoteMatchDetail>(),
                    result.data.matchDetail
                )
            }
            is NetworkResult.Error -> { /* Nothing */ }
            is NetworkResult.Exception -> { /* Nothing */ }
        }

    }
}