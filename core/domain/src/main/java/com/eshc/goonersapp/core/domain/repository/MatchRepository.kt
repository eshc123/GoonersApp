package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    fun getMatchesByMonth(startDate : String, endDate : String): Flow<List<Match>>
}