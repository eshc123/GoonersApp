package com.eshc.goonersapp.feature.team.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.usecase.player.GetPlayerDetailUseCase
import com.eshc.goonersapp.feature.team.state.PlayerDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    getPlayerDetailUseCase: GetPlayerDetailUseCase
) : ViewModel() {

    private val playerId: String = savedStateHandle.get<String>(PLAYER_ID_SAVED_STATE_KEY)!!

    val playerDetailUiState: StateFlow<PlayerDetailUiState> = getPlayerDetailUseCase(playerId.toInt())
        .catch {
            // TODO
        }
        .map { PlayerDetailUiState.Success(it) }
        .stateIn(
            viewModelScope, started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PlayerDetailUiState.Loading,
        )

    private val _selectedSeason = MutableStateFlow("")
    val selectedSeason : StateFlow<String> = _selectedSeason.asStateFlow()

    fun updateSelectedSeason(season : String){
        _selectedSeason.value = season
    }

    companion object {
        private const val PLAYER_ID_SAVED_STATE_KEY = "playerId"
    }
}