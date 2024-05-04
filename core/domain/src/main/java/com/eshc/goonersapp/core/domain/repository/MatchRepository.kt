package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchRecently
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    fun getMatch(match: Int): Flow<DataResult<Match>>

    fun getMatchInformation(match: Int, season: Int, opponent: Int): Flow<DataResult<MatchInformation>>

    fun getMatchesBySeason(seasonId : Int): Flow<DataResult<List<Match>>>

    fun getUpcomingMatches() : Flow<DataResult<List<Match>>>

    fun getRecentlyMatch() : Flow<DataResult<MatchRecently>>

}