package com.eshc.goonersapp.core.domain.usecase.match

import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentlyMatchUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) {

    operator fun invoke(): Flow<Match> =
        matchRepository.getRecentlyMatch()
}