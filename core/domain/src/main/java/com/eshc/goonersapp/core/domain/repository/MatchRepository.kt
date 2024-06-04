package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchData
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    fun getMatch(matchId: Int): Flow<DataResult<MatchData>>

    fun getMatchInformation(match: Int, season: Int, opponent: Int): Flow<DataResult<MatchInformation>>

    fun getMatchesBySeason(seasonId : Int): Flow<DataResult<List<Match>>>

    fun getUpcomingMatches() : Flow<DataResult<List<Match>>>

    fun getRecentlyMatch() : Flow<DataResult<MatchData>>

    fun getMatchLineup(matchId: Int) : Flow<DataResult<MatchLineup>>
}