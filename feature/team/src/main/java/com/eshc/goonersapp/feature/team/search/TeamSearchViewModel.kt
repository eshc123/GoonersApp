package com.eshc.goonersapp.feature.team.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.player.PlayerFilter
import com.eshc.goonersapp.core.domain.usecase.player.GetPlayersUseCase
import com.eshc.goonersapp.feature.team.model.TeamSearchUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TeamSearchViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    var query by mutableStateOf("")
        private set

    @OptIn(FlowPreview::class)
    private val debouncedSearchQuery: Flow<String> = snapshotFlow {
        query
    }.debounce(500)
        .filter { it.isNotEmpty() }
        .distinctUntilChanged()

    @OptIn(ExperimentalCoroutinesApi::class)
    val teamSearchUiModel =
        debouncedSearchQuery.filterNotNull()
            .flatMapLatest {
                getPlayersUseCase(PlayerFilter(keyword = it))
            }.catch {
                //TODO
            }.map { result ->
                when (result) {
                    is DataResult.Success -> TeamSearchUiModel(players = result.data.players)
                    is DataResult.Failure -> TeamSearchUiModel()
                }
            }.stateIn(
                viewModelScope,
                initialValue = TeamSearchUiModel(),
                started = SharingStarted.WhileSubscribed(500)
            )

    fun updateQuery(input: String) {
        query = input
    }
}