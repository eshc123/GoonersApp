package com.eshc.goonersapp.core.network.fake

import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import com.eshc.goonersapp.core.network.model.match.RemoteMatchTeam
import com.eshc.goonersapp.core.network.model.match.RemoteMatchUpcoming
import com.eshc.goonersapp.core.network.model.match.RemoteRecentlyMatch
import javax.inject.Inject

/**
 * Created By KanuKim97
 *
 * [FakeMatchDataSource]
 *  - fakeMatchDataSource used in data Layer Test and network Layer Unit Test
 *
 *  getMatchesBySeason(seasonId: Int)
 *  - if seasonId is over current year then return [NetworkResult.Error]
 *  - else return [NetworkResult.Success]
 *
 *  getUpcomingMatches()
 *   - return [NetworkResult.Success]
 *
 *  getRecentlyMatch()
 *   - return [NetworkResult.Success]
 */
class FakeMatchDataSource @Inject constructor(): MatchNetworkDataSource {
    override suspend fun getMatch(matchId: Int): NetworkResult<RemoteMatch> {
        return NetworkResult.Success(
            RemoteMatch(
                match = RemoteMatchTeam(),
                matchDetail = listOf()
            )
        )
    }

    override suspend fun getMatchInformation(
        matchId: Int,
        seasonId: Int,
        opponentId: Int,
    ): NetworkResult<RemoteMatchInformation> {



        return NetworkResult.Success(
            RemoteMatchInformation(
                notablePlayer = null,
                lineUp = listOf(),
                performance = listOf()
            )
        )
    }

    override suspend fun getMatchesBySeason(
        seasonId: Int
    ): NetworkResult<List<RemoteMatchTeam>> {
        return if (seasonId > 2024) {
            NetworkResult.Error(code = 404, message = "Not Found")
        } else {
            NetworkResult.Success(listOf())
        }
    }

    override suspend fun getUpcomingMatches(): NetworkResult<List<RemoteMatchUpcoming>> {
        return NetworkResult.Success(listOf())
    }

    override suspend fun getRecentlyMatch(): NetworkResult<RemoteRecentlyMatch> {
        return NetworkResult.Success(
            RemoteRecentlyMatch(
                match = RemoteMatchTeam(),
                matchDetail = listOf()
            )
        )
    }

}