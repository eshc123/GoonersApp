package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.fake.FakeSeasonDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.season.RemoteRank
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

/**
 * Created By KanuKim97
 *
 * [FakeSeasonDataSourceTest]
 *  - [FakeSeasonDataSource] test codes
 */
class FakeSeasonDataSourceTest {
    private lateinit var fakeSeasonDataSource: FakeSeasonDataSource

    @Before
    fun setUp() {
        fakeSeasonDataSource = FakeSeasonDataSource()
    }

    @Test
    fun fake_get_season_list_by_team_as_success() = runBlocking {
        when (val result = fakeSeasonDataSource.getSeasonListByTeam(19)) {
            is NetworkResult.Success -> {
                assertEquals(
                    "2023/2024",
                    result.data.first().season
                )
            }
            is NetworkResult.Error -> {
                fail("Test should not be reached here, excepted Network Result.Success")
            }
            is NetworkResult.Exception -> {
                fail("Test should not be reached here, excepted Network Result.Success")
            }
        }
    }

    @Test
    fun fake_get_season_list_by_team_as_error() = runBlocking {
        when (val result = fakeSeasonDataSource.getSeasonListByTeam(20)) {
            is NetworkResult.Error -> {
                assertEquals(404, result.code)
            }
            is NetworkResult.Success -> {
                fail("Test should not be reached here, excepted Network Result.Error")
            }
            is NetworkResult.Exception -> {
                fail("Test should not be reached here, excepted Network Result.Error")
            }
        }
    }

    @Test
    fun fake_get_league_list_as_current_season_by_team_as_success() = runBlocking {
        when (val result = fakeSeasonDataSource.getLeagueListAsCurrentSeasonByTeam(19)) {
            is NetworkResult.Success -> {
                assertEquals(
                    21366,
                    result.data.first().seasonId
                )
            }
            is NetworkResult.Error -> {
                fail("Test should not be reached here, excepted Network Result.Success")
            }
            is NetworkResult.Exception -> {
                fail("Test should not be reached here, excepted Network Result.Success")
            }
        }
    }

    @Test
    fun fake_get_league_list_as_current_season_by_team_as_error() = runBlocking {
        when (val result = fakeSeasonDataSource.getLeagueListAsCurrentSeasonByTeam(20)) {
            is NetworkResult.Error -> {
                assertEquals(404, result.code)
            }
            is NetworkResult.Success -> {
                fail("Test should not be reached here, excepted Network Result.Error")
            }
            is NetworkResult.Exception -> {
                fail("Test should not be reached here, excepted Network Result.Error")
            }
        }
    }

    @Test
    fun fake_get_preview_rank_list_by_team_and_season_as_success() = runBlocking {
        val result = fakeSeasonDataSource.getPreviewRankListByTeamAndSeason(
            teamId = 19,
            seasonId = 21366
        )

        when (result) {
            is NetworkResult.Success -> {
                assertEquals(listOf<RemoteRank>(), result.data)
            }
            is NetworkResult.Error -> {
                fail("Test should not be reached here, excepted Network Result.Success")
            }
            is NetworkResult.Exception -> {
                fail("Test should not be reached here, excepted Network Result.Success")
            }
        }
    }


    @Test
    fun fake_get_preview_rank_list_by_team_and_season_as_error() = runBlocking {
        val result = fakeSeasonDataSource.getPreviewRankListByTeamAndSeason(
            teamId = 20,
            seasonId = 21366
        )

        when (result) {
            is NetworkResult.Error -> {
                assertEquals(404, result.code)
            }
            is NetworkResult.Success -> {
                fail("Test should not be reached here, excepted Network Result.Error")
            }
            is NetworkResult.Exception -> {
                fail("Test should not be reached here, excepted Network Result.Error")
            }
        }
    }
}