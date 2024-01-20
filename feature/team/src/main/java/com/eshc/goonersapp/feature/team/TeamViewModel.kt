package com.eshc.goonersapp.feature.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.usecase.GetPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    val items = MutableStateFlow<List<Player>>(emptyList())

    init {
        viewModelScope.launch {
            getPlayersUseCase.invoke().collect {
                items.emit(it)
            }
        }
    }
}