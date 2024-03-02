package com.eshc.goonersapp.core.domain.usecase.team

import com.eshc.goonersapp.core.domain.model.team.TeamDetail
import com.eshc.goonersapp.core.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamDetailUseCase   @Inject constructor(
    private val teamRepository: TeamRepository
) {

    operator fun invoke(): Flow<TeamDetail> =
        teamRepository.getTeamDetail()
}