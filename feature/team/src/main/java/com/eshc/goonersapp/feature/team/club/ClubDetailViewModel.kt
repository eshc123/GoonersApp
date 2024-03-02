package com.eshc.goonersapp.feature.team.club

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.usecase.team.GetTeamDetailUseCase
import com.eshc.goonersapp.feature.team.state.ClubDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ClubDetailViewModel @Inject constructor(
    getTeamDetailUseCase: GetTeamDetailUseCase
) : ViewModel() {

    val clubDetail: StateFlow<ClubDetailUiState> = getTeamDetailUseCase()
        .catch {
            // TODO
        }.map {
            ClubDetailUiState.Success(it)
        }
        .stateIn(
            viewModelScope, started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ClubDetailUiState.Loading,
        )

}