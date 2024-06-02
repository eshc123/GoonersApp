package com.eshc.goonersapp.core.domain.usecase.season

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.season.Rank
import com.eshc.goonersapp.core.domain.repository.SeasonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPreviewRankListByTeamAndSeasonUseCase @Inject constructor(
    private val seasonRepository: SeasonRepository
) {
    operator fun invoke(
        teamId: Int,
        seasonId: Int
    ): Flow<DataResult<List<Rank>>> = seasonRepository.getPreviewRankListByTeamAndSeason(
        teamId = teamId,
        seasonId = seasonId
    )
}