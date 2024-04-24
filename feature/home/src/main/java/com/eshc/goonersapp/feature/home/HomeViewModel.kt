package com.eshc.goonersapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchRecently
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

    private val _recentlyMatch = MutableStateFlow<MatchRecently?>(null)
    val recentlyMatch : StateFlow<MatchRecently?> = _recentlyMatch.asStateFlow()

    init {
        viewModelScope.launch {
            getUpcomingMatchesUseCase()
                .catch { /* TODO("Not yet implemented") */ }
                .collect {
                    when(it){
                        is DataResult.Success -> _upcomingMatches.emit(it.data)
                        is DataResult.Failure -> { /* TODO("Not yet implemented") */ }
                    }
                }

            getRecentlyMatchUseCase()
                .catch { /* TODO("Not yet implemented") */ }
                .collect {
                    when(it){
                        is DataResult.Success ->  _recentlyMatch.emit(it.data)
                        is DataResult.Failure -> { /* TODO("Not yet implemented") */ }
                    }
                }
        }
    }
}