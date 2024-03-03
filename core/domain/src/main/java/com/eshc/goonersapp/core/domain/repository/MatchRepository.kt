package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    fun getMatchesBySeason(season : String): Flow<DataResult<List<Match>>>

    fun getUpcomingMatches() : Flow<DataResult<List<Match>>>

    fun getRecentlyMatch() : Flow<DataResult<Match>>

}