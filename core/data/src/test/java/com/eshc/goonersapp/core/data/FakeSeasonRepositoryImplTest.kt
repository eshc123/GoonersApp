package com.eshc.goonersapp.core.data

import com.eshc.goonersapp.core.data.fake.FakeSeasonRepositoryImpl
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.season.Rank
import com.eshc.goonersapp.core.domain.repository.SeasonRepository
import com.eshc.goonersapp.core.network.fake.FakeSeasonDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

/**
 * Created By KanuKim97
 *
 * [FakeSeasonRepositoryImplTest]
 *  - FakeSeasonRepository Test
 */
class FakeSeasonRepositoryImplTest {
    private lateinit var fakeSeasonDataSource: FakeSeasonDataSource
    private lateinit var fakeSeasonRepository: SeasonRepository

    @Before
    fun setUp() {
        fakeSeasonDataSource = FakeSeasonDataSource()
        fakeSeasonRepository = FakeSeasonRepositoryImpl(fakeSeasonDataSource)
    }

    @Test
    fun fake_get_season_list_by_team_flow_collect_as_success() = runBlocking {
        fakeSeasonRepository.getSeasonListByTeam(teamId = 19).collect { result ->
            when (result) {
                is DataResult.Success -> {
                    assertEquals(
                        "2023/2024",
                        result.data.first().season
                    )
                }
                is DataResult.Failure -> fail("Test should not be reached here")
            }
        }
    }

    @Test
    fun fake_get_season_list_by_team_flow_collect_as_fail() = runBlocking {
        fakeSeasonRepository.getSeasonListByTeam(teamId = 20).collect { result ->
            when (result) {
                is DataResult.Success -> fail("Test should not be reached here")
                is DataResult.Failure -> assertEquals(404, result.code)
            }
        }
    }

    @Test
    fun fake_get_league_list_as_current_season_by_team_as_success() = runBlocking {
        fakeSeasonRepository.getLeagueListAsCurrentSeasonByTeam(19).collect { result ->
            when(result) {
                is DataResult.Success -> {
                    assertEquals(
                        21366,
                        result.data.first().seasonId
                    )
                }
                is DataResult.Failure -> fail("Test should not be reached here")
            }
        }
    }


    @Test
    fun fake_get_league_list_as_current_season_by_team_as_fail() = runBlocking {
        fakeSeasonRepository.getLeagueListAsCurrentSeasonByTeam(20).collect { result ->
            when(result) {
                is DataResult.Success -> fail("Test should not be reached here")
                is DataResult.Failure -> assertEquals(404, result.code)
            }
        }
    }

    @Test
    fun fake_get_preview_rank_list_by_team_and_season_as_success() = runBlocking {
        fakeSeasonRepository.getPreviewRankListByTeamAndSeason(
            teamId = 19,
            seasonId = 21366
        ).collect { result ->
            when (result) {
                is DataResult.Success -> {
                    assertEquals(
                        listOf<Rank>(),
                        result.data
                    )
                }
                is DataResult.Failure -> fail("Test should not be reached here")
            }
        }
    }

    @Test
    fun fake_get_preview_rank_list_by_team_and_season_as_fail() = runBlocking {
        fakeSeasonRepository.getPreviewRankListByTeamAndSeason(
            teamId = 20,
            seasonId = 21366
        ).collect { result ->
            when (result) {
                is DataResult.Success -> fail("Test should not be reached here")
                is DataResult.Failure -> assertEquals(404, result.code)
            }
        }
    }
}