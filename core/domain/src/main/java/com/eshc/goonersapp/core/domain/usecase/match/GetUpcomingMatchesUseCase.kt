package com.eshc.goonersapp.core.domain.usecase.match

import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUpcomingMatchesUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) {

    operator fun invoke(): Flow<List<Match>> =
        matchRepository.getUpcomingMatches()
}