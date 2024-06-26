package com.eshc.goonersapp.feature.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.usecase.player.GetPlayersUseCase
import com.eshc.goonersapp.feature.team.state.TeamUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    val players: StateFlow<TeamUiState> =
        getPlayersUseCase()
            .map {
                when(it){
                    is DataResult.Success -> {
                        TeamUiState.Success(it.data.players)
                    }
                    is DataResult.Failure -> {
                        TeamUiState.Error
                    }
                }
            }.stateIn(
                scope = viewModelScope,
                initialValue = TeamUiState.Loading,
                started = SharingStarted.Eagerly
            )
}