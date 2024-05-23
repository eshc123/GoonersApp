package com.eshc.goonersapp.core.network.fake

import com.eshc.goonersapp.core.network.MatchNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.match.Performance
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchData
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import javax.inject.Inject

/**
 * Created By KanuKim97
 *
 * [FakeMatchDataSource]
 *  - fakeMatchDataSource used in data Layer Test and network Layer Unit Test
 *
 *  getMatch(matchId: Int)
 *  - if matchId is over 39 then return [NetworkResult.Error]
 *  - else return [NetworkResult.Success]
 *
 *  getMatchInformation(matchId: Int, seasonId: Int, opponentId: Int)
 *  - if matchId is over 39 and seasonId over current year and opponentId under 38 then return [NetworkResult.Error]
 *  - else return [NetworkResult.Success]
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
    override suspend fun getMatch(matchId: Int): NetworkResult<RemoteMatchData> {

        return if (matchId < 39) {
            NetworkResult.Success(
                RemoteMatchData(
                    match = RemoteMatch(matchId = matchId),
                    matchDetail = listOf()
                )
            )
        } else {
            NetworkResult.Error(code = 404, message = "Not Found")
        }
    }

    override suspend fun getMatchInformation(
        matchId: Int,
        seasonId: Int,
        opponentId: Int,
    ): NetworkResult<RemoteMatchInformation> {

        return if (matchId < 39 && seasonId < 2025 && opponentId > 38) {
            NetworkResult.Success(
                RemoteMatchInformation(
                    notablePlayer = null,
                    performance = Performance()
                )
            )
        } else {
            NetworkResult.Error(code = 404, message = "Not Found")
        }
    }

    override suspend fun getMatchesBySeason(
        seasonId: Int
    ): NetworkResult<List<RemoteMatch>> {
        return if (seasonId > 21646) {
            NetworkResult.Error(code = 404, message = "Not Found")
        } else {
            NetworkResult.Success(listOf())
        }
    }

    override suspend fun getUpcomingMatches(): NetworkResult<List<RemoteMatch>> {
        return NetworkResult.Success(listOf())
    }

    override suspend fun getRecentlyMatch(): NetworkResult<RemoteMatchData> {
        return NetworkResult.Success(
            RemoteMatchData(
                match = RemoteMatch(),
                matchDetail = listOf()
            )
        )
    }

}