package com.eshc.goonersapp.feature.match.state

import com.eshc.goonersapp.core.common.state.UiState
import com.eshc.goonersapp.core.domain.model.match.MatchDetail
import com.eshc.goonersapp.feature.match.model.MatchUiModel

data class MatchDetailUiState (
    val match : MatchUiModel,
    val matchDetailState : UiState<List<MatchDetail>>
)