package com.eshc.goonersapp.feature.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.core.domain.usecase.player.GetPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players: StateFlow<List<Player>> = _players.asStateFlow()

    init {
        viewModelScope.launch {
            getPlayersUseCase()
                .catch {
                    //TODO
                }.collect {
                    when(it){
                        is DataResult.Success -> {
                            _players.emit(it.data)
                        }
                        is DataResult.Failure -> {

                        }
                    }

                }
        }
    }
}