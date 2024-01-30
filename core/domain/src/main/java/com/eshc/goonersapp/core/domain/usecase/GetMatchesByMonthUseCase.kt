package com.eshc.goonersapp.core.domain.usecase

import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchesByMonthUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) {

    operator fun invoke(startDate : String, endDate : String): Flow<List<Match>> =
        matchRepository.getMatchesByMonth(startDate,endDate)
}