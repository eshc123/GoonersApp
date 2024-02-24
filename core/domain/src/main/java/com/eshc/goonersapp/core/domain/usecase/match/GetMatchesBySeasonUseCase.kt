package com.eshc.goonersapp.core.domain.usecase.match

import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchesBySeasonUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) {

    operator fun invoke(season : String): Flow<List<Match>> =
        matchRepository.getMatchesBySeason(season)
}