package com.eshc.goonersapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.core.domain.usecase.match.GetRecentlyMatchUseCase
import com.eshc.goonersapp.core.domain.usecase.match.GetUpcomingMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUpcomingMatchesUseCase: GetUpcomingMatchesUseCase,
    private val getRecentlyMatchUseCase: GetRecentlyMatchUseCase
) : ViewModel() {
    private val _upcomingMatches = MutableStateFlow<List<Match>>(emptyList())
    val upcomingMatches : StateFlow<List<Match>> = _upcomingMatches.asStateFlow()

    private val _recentlyMatch = MutableStateFlow<Match?>(null)
    val recentlyMatch : StateFlow<Match?> = _recentlyMatch.asStateFlow()

    init {
        viewModelScope.launch {
            getUpcomingMatchesUseCase()
                .catch {
                    //TODO
                }.collect {
                    _upcomingMatches.emit(
                        it
                    )
                }

            getRecentlyMatchUseCase()
                .catch {
                    //TODO
                }.collect {
                    _recentlyMatch.emit(it)
                }
        }
    }
}