package com.eshc.goonersapp.feature.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.usecase.match.GetMatchesBySeasonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getMatchesBySeasonUseCase : GetMatchesBySeasonUseCase
) : ViewModel() {
    private val _matches = MutableStateFlow<List<Match>>(emptyList())
    val matches : StateFlow<List<Match>> = _matches.asStateFlow()

    init {
        fetchMatchesBySeason("2023-2024")
    }

    fun fetchMatchesBySeason(
        season : String
    ){
        viewModelScope.launch {
            getMatchesBySeasonUseCase(season)
                .catch {
                    //TODO Error
                }.collect {
                    _matches.emit(it)
                }
        }
    }
}