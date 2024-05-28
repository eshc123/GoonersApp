package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.season.League
import com.eshc.goonersapp.core.domain.model.season.Rank
import com.eshc.goonersapp.core.domain.model.season.Season
import kotlinx.coroutines.flow.Flow

interface SeasonRepository {

    fun getSeasonListByTeam(teamId: Int): Flow<DataResult<List<Season>>>

    fun getLeagueListAsCurrentSeasonByTeam(teamId: Int): Flow<DataResult<List<League>>>

    fun getPreviewRankListByTeamAndSeason(
        teamId: Int,
        seasonId: Int
    ): Flow<DataResult<List<Rank>>>
}