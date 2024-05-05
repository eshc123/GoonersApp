package com.eshc.goonersapp.feature.match.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchData
import com.eshc.goonersapp.core.domain.usecase.match.GetMatchDetailUseCase
import com.eshc.goonersapp.feature.match.model.MatchUiModel
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
    val matchDetail : StateFlow<MatchData> = getMatchDetailUseCase(
        matchId = _match.value.id
    ).map {
            when(it){
                is DataResult.Success -> {
                    it.data
                }
                is DataResult.Failure -> {
                    MatchData(
                        match = Match(id = 0),
                        matchDetail = emptyList()
                    )
                }
            }
        }.stateIn(
            scope = viewModelScope,
            initialValue = MatchData(
                match = Match(
                    id = _match.value.id
                ),
                matchDetail = emptyList()
            ),
            started = SharingStarted.Eagerly
        )

    companion object {
        private const val MATCH_SAVED_STATE_KEY = "match"
    }
}