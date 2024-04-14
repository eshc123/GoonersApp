package com.eshc.goonersapp.core.domain.usecase.match

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchInformationUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) {
    operator fun invoke(
        match: Int,
        season: Int,
        opponent: Int
    ): Flow<DataResult<MatchInformation>> = matchRepository.getMatchInformation(
        match,
        season,
        opponent
    )
}