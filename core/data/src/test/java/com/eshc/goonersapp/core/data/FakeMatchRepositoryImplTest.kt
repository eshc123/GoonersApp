package com.eshc.goonersapp.core.data

import com.eshc.goonersapp.core.data.fake.FakeMatchRepositoryImpl
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchData
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import com.eshc.goonersapp.core.domain.model.match.Performance
import com.eshc.goonersapp.core.domain.model.match.TeamLineup
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.fake.FakeMatchDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created By KanuKim97
 *
 * [FakeMatchRepositoryImplTest]
 *  - FakeMatchRepository Test
 */
class FakeMatchRepositoryImplTest {
    private lateinit var fakeMatchDataSource: FakeMatchDataSource
    private lateinit var fakeMatchRepository: MatchRepository

    @Before
    fun setUp() {
        fakeMatchDataSource = FakeMatchDataSource()
        fakeMatchRepository = FakeMatchRepositoryImpl(fakeMatchDataSource)
    }

    @Test
    fun testMatchWithFake() = runBlocking {
        fakeMatchRepository.getMatch(38).collect { result ->
            when (result) {
                is DataResult.Success -> {
                    assertEquals(
                        MatchData(
                            match = Match(
                                id = 38
                            ),
                            matchDetail = listOf()
                        ),
                        result.data
                    )
                }
                is DataResult.Failure -> { assertEquals(404, result.code) }
            }
        }
    }


    @Test
    fun testMatchInformationWithFake() = runBlocking {
        fakeMatchRepository.getMatchInformation(
            match = 38,
            season = 2024,
            opponent = 40
        ).collect { result ->
            when (result) {
                is DataResult.Success -> {
                    assertEquals(
                        MatchInformation(
                            notablePlayer = null,
                            performance = Performance(opponentImageUrl = "", win = 0, draw = 0, lose = 0)
                        ),
                        result.data
                    )
                }
                is DataResult.Failure -> { assertEquals(404, result.code) }
            }
        }
    }

    @Test
    fun testMatchBySeasonsWithFake() = runBlocking {
        fakeMatchRepository.getMatchesBySeason(21646).collect { result ->
            when (result) {
                is DataResult.Success -> { assertEquals(listOf<Match>(), result.data) }
                is DataResult.Failure -> { assertEquals(404, result.code) }
            }
        }
    }

    @Test
    fun testUpcomingMatchesWithFake() = runBlocking {
        fakeMatchRepository.getUpcomingMatches().collect { result ->
            when (result) {
                is DataResult.Success -> { assertEquals(listOf<Match>(), result.data) }
                is DataResult.Failure -> { /* Nothing */ }
            }
        }
    }

    @Test
    fun testRecentlyMatchesWithFake() = runBlocking {
        fakeMatchRepository.getRecentlyMatch().collect { result ->
            when (result) {
                is DataResult.Success -> {
                    assertEquals(
                        MatchData(
                            match = Match(),
                            matchDetail = listOf()
                        ),
                        result.data
                    )
                }
                is DataResult.Failure -> { /* Nothing */ }
            }
        }
    }

    @Test
    fun testMatchLineupWithFake() = runBlocking {
        fakeMatchRepository.getMatchLineup(38).collect { result ->
            when (result) {
                is DataResult.Success -> {
                    assertEquals(
                        MatchLineup(
                            homeLineup = TeamLineup(
                                teamId = 0,
                                formation = "",
                                playerLineup = emptyList()
                            ),
                            awayLineup = TeamLineup(
                                teamId = 0,
                                formation = "",
                                playerLineup = emptyList()
                            )
                        ),
                        result.data
                    )
                }
                is DataResult.Failure -> { /* Nothing */ }
            }
        }
    }
}