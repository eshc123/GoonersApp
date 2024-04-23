package com.eshc.goonersapp.core.data

import com.eshc.goonersapp.core.data.fake.FakeMatchRepositoryImpl
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchRecently
import com.eshc.goonersapp.core.domain.model.match.Performance
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import com.eshc.goonersapp.core.network.fake.FakeMatchDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Created By KanuKim97
 *
 * [FakeMatchTest]
 *  - FakeMatchRepository Test
 */
class FakeMatchTest {
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
                        Match(id = 38),
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
                            lineUp = listOf(),
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
        fakeMatchRepository.getMatchesBySeason("2025").collect { result ->
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
                        MatchRecently(
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
}