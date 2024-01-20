package com.eshc.goonersapp.feature.team.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.usecase.GetPlayerDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    getPlayerDetailUseCase: GetPlayerDetailUseCase
) : ViewModel() {

    private val playerId: String = savedStateHandle.get<String>(PLAYER_ID_SAVED_STATE_KEY)!!

    val playerDetail: StateFlow<Player> = getPlayerDetailUseCase(playerId.toInt())
        .stateIn(
            viewModelScope, started = SharingStarted.WhileSubscribed(5_000),
            initialValue = Player(-1),
        )

    companion object {
        private const val PLAYER_ID_SAVED_STATE_KEY = "playerId"
    }
}