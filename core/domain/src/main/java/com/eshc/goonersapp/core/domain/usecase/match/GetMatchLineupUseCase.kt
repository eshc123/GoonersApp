package com.eshc.goonersapp.core.domain.usecase.match

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchLineupUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) {
    operator fun invoke(
        matchId: Int,
    ): Flow<DataResult<MatchLineup>> = matchRepository.getMatchLineup(
        matchId
    )
}