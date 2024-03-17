package com.eshc.goonersapp.feature.team

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.core.domain.model.player.PlayerPosition
import com.eshc.goonersapp.feature.team.ui.SquadPlayerCard

@Composable
fun TeamRoute(
    topBar : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
    onPlayerClick: (String) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    Scaffold(
        topBar = {
            topBar()
        },
        bottomBar = {
            bottomBar()
        }
    ) { padding ->
        TeamScreen(
            modifier = Modifier.padding(padding),
            onClick = onPlayerClick
        )
    }
}

@Composable
fun TeamScreen(
    modifier: Modifier = Modifier,
    viewModel: TeamViewModel = hiltViewModel(),
    onClick: (String) -> Unit
) {
    val players by viewModel.players.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()

    if (players.isNotEmpty()) {
        Column(
            modifier = modifier
                .padding(top = 12.dp)
                .verticalScroll(scrollState)
        ) {
            PlayerPosition.entries.forEach { position ->
                HorizontalPlayerListByPosition(
                    position = position.name,
                    filteredPlayers = players.filter { it.positionCategory == position.positionCategory },
                    onClick = onClick
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
        }
    } else {
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

@Composable
fun ColumnScope.HorizontalPlayerListByPosition(
    position: String,
    filteredPlayers: List<Player>,
    onClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Max)
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 8.dp),
            text = position,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
        )
        Divider(
            modifier = Modifier
                .padding(start = 8.dp, bottom = 12.dp)
                .width(20.dp), thickness = 4.dp
        )
    }
    if (filteredPlayers.isNotEmpty()) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                filteredPlayers
            ) {
                SquadPlayerCard(
                    it, onClick
                )
            }
        }
    }
    else {
        Box(
            modifier = Modifier.fillMaxWidth().height(216.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }
}