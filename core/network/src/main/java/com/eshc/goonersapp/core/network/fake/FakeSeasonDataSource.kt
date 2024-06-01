package com.eshc.goonersapp.core.network.fake

import com.eshc.goonersapp.core.network.SeasonNetworkDataSource
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.season.RemoteLeague
import com.eshc.goonersapp.core.network.model.season.RemoteRank
import com.eshc.goonersapp.core.network.model.season.RemoteSeason
import javax.inject.Inject

/**
 * Created By KanuKim97
 *
 * [FakeSeasonDataSource]
 *  - fakeSeasonDataSource used in data Layer Test and network Layer Unit Test
 */
class FakeSeasonDataSource @Inject constructor(): SeasonNetworkDataSource {
    override suspend fun getSeasonListByTeam(teamId: Int): NetworkResult<List<RemoteSeason>> {
        return if (teamId == 19) {
            NetworkResult.Success(
                listOf(
                    RemoteSeason(
                        seasonId = 21366,
                        season = "2023/2024"
                    ),
                    RemoteSeason(
                        seasonId = 21365,
                        season = "2022/2023"
                    )
                )
            )
        } else {
            NetworkResult.Error(code = 404, message = "Not Found")
        }
    }

    override suspend fun getLeagueListAsCurrentSeasonByTeam(
        teamId: Int
    ): NetworkResult<List<RemoteLeague>> {
        return if (teamId == 19) {
            NetworkResult.Success(
                listOf(
                    RemoteLeague(
                        leagueId = 1,
                        leagueName = "Premier League",
                        shortCode = "PL",
                        leagueImageUrl = "",
                        seasonId = 21366,
                        season = "2023/2024",
                        teamId = teamId
                    )
                )
            )
        } else {
            NetworkResult.Error(code = 404, message = "Not Found")
        }
    }

    override suspend fun getPreviewRankListByTeamAndSeason(
        teamId: Int,
        seasonId: Int,
    ): NetworkResult<List<RemoteRank>> {
        return if (teamId == 19 && seasonId < 21367) {
            NetworkResult.Success(listOf())
        } else {
            NetworkResult.Error(404, "Not Found")
        }
    }
}