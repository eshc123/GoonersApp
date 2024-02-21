package com.eshc.goonersapp.feature.match.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import com.eshc.goonersapp.feature.match.model.MatchUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val match = savedStateHandle.getStateFlow(MATCH_SAVED_STATE_KEY,MatchUiModel(0))

    companion object {
        private const val MATCH_SAVED_STATE_KEY = "match"
    }
}