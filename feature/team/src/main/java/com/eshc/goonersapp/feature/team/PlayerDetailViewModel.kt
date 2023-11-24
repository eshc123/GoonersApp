package com.eshc.goonersapp.feature.team

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.network.GnrRemoteDataSource
import com.eshc.goonersapp.core.network.model.RemotePlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val gnrRemoteDataSource: GnrRemoteDataSource
) : ViewModel() {

    private val playerId: String = savedStateHandle.get<String>(PLAYER_ID_SAVED_STATE_KEY)!!

    val playerDetail: StateFlow<RemotePlayer> =
        flow {
            emit(gnrRemoteDataSource.getPlayer(playerId))
        }.stateIn(
            viewModelScope, started = SharingStarted.WhileSubscribed(5_000),
            initialValue = RemotePlayer("-1"),
        )


    companion object {
        private const val PLAYER_ID_SAVED_STATE_KEY = "playerId"
    }
}