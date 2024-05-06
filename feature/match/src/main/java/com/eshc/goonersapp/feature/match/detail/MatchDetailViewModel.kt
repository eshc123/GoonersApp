package com.eshc.goonersapp.feature.match.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.common.state.UiState
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.usecase.match.GetMatchDetailUseCase
import com.eshc.goonersapp.feature.match.model.MatchUiModel
import com.eshc.goonersapp.feature.match.model.toUiModel
import com.eshc.goonersapp.feature.match.state.MatchDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    getMatchDetailUseCase : GetMatchDetailUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _match = savedStateHandle.getStateFlow(MATCH_SAVED_STATE_KEY,MatchUiModel(0))

    val matchDetailUiState : StateFlow<MatchDetailUiState> = getMatchDetailUseCase(
        matchId = _match.value.id
    ).map {
            when(it){
                is DataResult.Success -> {
                    MatchDetailUiState(
                        match = it.data.match.toUiModel(),
                        matchDetailState = UiState.Success(it.data.matchDetail)
                    )
                }
                is DataResult.Failure -> {
                    MatchDetailUiState(
                        match = _match.value,
                        matchDetailState = UiState.Error
                    )
                }
            }
        }.stateIn(
            scope = viewModelScope,
            initialValue = MatchDetailUiState(
                match = _match.value,
                matchDetailState = UiState.Loading
            ),
            started = SharingStarted.Eagerly
        )

    companion object {
        private const val MATCH_SAVED_STATE_KEY = "match"
    }
}