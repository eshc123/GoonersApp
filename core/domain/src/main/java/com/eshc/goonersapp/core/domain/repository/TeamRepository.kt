package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.team.TeamDetail
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getTeamDetail() : Flow<DataResult<TeamDetail>>
}