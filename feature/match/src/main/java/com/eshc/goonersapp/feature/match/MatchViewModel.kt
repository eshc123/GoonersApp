package com.eshc.goonersapp.feature.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.usecase.match.GetMatchesBySeasonUseCase
import com.eshc.goonersapp.feature.match.event.UpdateMonthEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    getMatchesBySeasonUseCase : GetMatchesBySeasonUseCase
) : ViewModel() {

    private val _mUpdateCurrentMonthEvent = MutableSharedFlow<UpdateMonthEvent>()
    val mUpdateCurrentMonthEvent : SharedFlow<UpdateMonthEvent> = _mUpdateCurrentMonthEvent.asSharedFlow()

    val matches : StateFlow<List<Match>> =
        getMatchesBySeasonUseCase(21646)
            .map {
                when(it){
                    is DataResult.Success -> {
                        it.data
                    }
                    is DataResult.Failure -> {
                        emptyList()
                    }
                }
            }.stateIn(
                scope = viewModelScope,
                initialValue = emptyList(),
                started = SharingStarted.Eagerly
            )

    fun updateCurrentMonth(updateMonthEvent: UpdateMonthEvent){
        viewModelScope.launch {
            _mUpdateCurrentMonthEvent.emit(updateMonthEvent)
        }
    }
}