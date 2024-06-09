package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.fake.FakePlayerNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.player.RemotePlayer
import com.eshc.goonersapp.core.network.model.player.RemotePlayerList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

/**
 * Created By Jung SeokJoon
 *
 * [FakePlayerDataSourceTest]
 *  - [FakePlayerNetworkDataSource] test codes
 */

class FakePlayerDataSourceTest {
    private lateinit var fakePlayerNetworkDataSource: FakePlayerNetworkDataSource
    private val player = RemotePlayer(playerId = 1)
    private val playerList = listOf(player)

    @Before
    fun setUp() {
        fakePlayerNetworkDataSource = FakePlayerNetworkDataSource()
    }

    @Test
    fun `fake_get_player_list_as_success`() = runBlocking {
        fakePlayerNetworkDataSource.setResponseForPlayerList {
            RemotePlayerList(
                teamPlayer = playerList
            )
        }

        when (val result = fakePlayerNetworkDataSource.getPlayerList()) {
            is NetworkResult.Success -> {
                Assert.assertEquals(
                    playerList,
                    result.data
                )
            }

            is NetworkResult.Error -> {
                fail("Test should not reach here, expected NetworkResult.Success")
            }

            is NetworkResult.Exception -> {
                fail("Test should not reach here, expected NetworkResult.Success")
            }
        }
    }

    @Test
    fun `fake_get_player_list_as_error`() = runBlocking {
        fakePlayerNetworkDataSource.setResponseForPlayerList(null)

        when (val result = fakePlayerNetworkDataSource.getPlayerList()) {
            is NetworkResult.Success -> {
                fail("Test should not reach here, expected NetworkResult.Error")
            }

            is NetworkResult.Error -> {
                Assert.assertEquals(404, result.code)
            }

            is NetworkResult.Exception -> {
                fail("Test should not reach here, expected NetworkResult.Error")
            }
        }
    }

    @Test
    fun `fake_get_player_detail_as_success`() = runBlocking {
        fakePlayerNetworkDataSource.setResponseForPlayerDetail {
            player
        }

        when (val result = fakePlayerNetworkDataSource.getPlayerDetail(playerId = 1)) {
            is NetworkResult.Success -> {
                Assert.assertEquals(
                    player,
                    result.data
                )
            }

            is NetworkResult.Error -> {
                fail("Test should not reach here, expected NetworkResult.Success")
            }

            is NetworkResult.Exception -> {
                fail("Test should not reach here, expected NetworkResult.Success")
            }
        }
    }

    @Test
    fun `fake_get_player_detail_as_error`() = runBlocking {
        fakePlayerNetworkDataSource.setResponseForPlayerDetail(null)

        when (val result = fakePlayerNetworkDataSource.getPlayerDetail(playerId = 1)) {
            is NetworkResult.Success -> {
                fail("Test should not reach here, expected NetworkResult.Error")
            }

            is NetworkResult.Error -> {
                Assert.assertEquals(404, result.code)
            }

            is NetworkResult.Exception -> {
                fail("Test should not reach here, expected NetworkResult.Error")
            }
        }
    }


}