package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.TeamDetail
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getTeamDetail() : Flow<TeamDetail>
}