package com.eshc.goonersapp.feature.team

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.designsystem.component.GnrDropdownMenu
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.core.domain.model.player.PlayerPosition
import com.eshc.goonersapp.feature.team.state.TeamUiState
import com.eshc.goonersapp.feature.team.ui.SquadPlayerCard

@Composable
fun TeamRootScreen(
    topBar : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
    onPlayerClick: (String) -> Unit,
    onShowSnackbar : (String) -> Unit,
    viewModel: TeamViewModel = hiltViewModel(),
) {
    val teamUiState by viewModel.players.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            topBar()
        },
        bottomBar = {
            bottomBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            TeamScreen(
                teamUiState = teamUiState,
                scrollState = scrollState,
                onClick = onPlayerClick
            )
        }
    }
}

@Composable
fun ColumnScope.TeamScreen(
    teamUiState : TeamUiState,
    scrollState : ScrollState,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    GnrDropdownMenu(
        modifier = Modifier.padding(horizontal = 24.dp),
        label = "season",
        items = listOf("2023-2024","2022-2023"),
        onItemSelected = { index, item ->
            //TODO
        }
    )

    when(teamUiState){
        is TeamUiState.Success -> {
            Column(
                modifier = modifier
                    .padding(top = 12.dp)
                    .verticalScroll(scrollState)
            ) {
                PlayerPosition.entries.forEach { position ->
                    HorizontalPlayerListByPosition(
                        position = position.name,
                        filteredPlayers = teamUiState.players
                            .filter { it.positionCategory == position.positionCategory }
                            .sortedBy { it.backNumber },
                        onClick = onClick
                    )
                }
            }
        }
        is TeamUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is TeamUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Players cannot be loaded.",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.LightGray,
                )
            }
        }
    }
}

@Composable
fun ColumnScope.HorizontalPlayerListByPosition(
    position: String,
    filteredPlayers: List<Player>,
    onClick: (String) -> Unit
) {
    Text(
        modifier = Modifier.padding(top = 8.dp, start = 15.dp, bottom = 14.dp),
        text = position,
        style = GnrTypography.subtitleMedium,
        color = Color.Black,
    )
    if (filteredPlayers.isNotEmpty()) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                items = filteredPlayers,
                key = {
                    it.id
                }
            ) { player ->
                SquadPlayerCard(
                    player = player,
                    onClick = onClick
                )
            }
        }
    }
    else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(153.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }
}