package com.eshc.goonersapp.core.domain.usecase.season

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.season.League
import com.eshc.goonersapp.core.domain.repository.SeasonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLeagueListAsCurrentSeasonByTeamUseCase @Inject constructor(
    private val seasonRepository: SeasonRepository
) {
    operator fun invoke(
        teamId: Int
    ): Flow<DataResult<List<League>>> = seasonRepository.getLeagueListAsCurrentSeasonByTeam(teamId)
}