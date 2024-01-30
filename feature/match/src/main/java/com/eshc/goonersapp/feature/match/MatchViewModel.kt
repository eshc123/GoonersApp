package com.eshc.goonersapp.feature.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.usecase.GetMatchesByMonthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getMatchesByMonthUseCase : GetMatchesByMonthUseCase
) : ViewModel() {
    private val _matches = MutableStateFlow<List<Match>>(emptyList())
    val matches : StateFlow<List<Match>> = _matches.asStateFlow()

    private val alreadyFetchedMonthStartDateSet = mutableSetOf<String>()

    fun fetchMatchesByMonth(
        startDate : String,
        endDate : String
    ){
        if(!alreadyFetchedMonthStartDateSet.contains(startDate)) {
            viewModelScope.launch {
                getMatchesByMonthUseCase(startDate, endDate)
                    .catch {
                        //TODO Error
                    }.collect {
                        alreadyFetchedMonthStartDateSet.add(startDate)
                        _matches.emit((matches.value + it).distinctBy { it.id })
                    }
            }
        }
    }
}