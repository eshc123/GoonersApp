package com.eshc.goonersapp.feature.team.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.GnrTextFiled
import com.eshc.goonersapp.core.designsystem.component.GnrTopBar
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.team.model.TeamSearchUiModel

@Composable
fun TeamSearchRootScreen(
    onClick: (String) -> Unit,
    onBackIconClick: () -> Unit,
    onShowSnackbar: (String) -> Unit,
    viewModel: TeamSearchViewModel = hiltViewModel()
) {

    val teamSearchUiModel by viewModel.teamSearchUiModel.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            GnrTopBar(
                title = "Search",
                onBackIconClick = onBackIconClick
            )
        }
    ) { paddingValues ->
        TeamSearchScreen(
            teamSearchUiModel = teamSearchUiModel,
            onClick = onClick,
            text = viewModel.query,
            onQueryChange = viewModel::updateQuery,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun TeamSearchScreen(
    teamSearchUiModel: TeamSearchUiModel,
    onClick: (String) -> Unit,
    text : String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        GnrTextFiled(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            text = text,
            onValueChange = onQueryChange
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            items(teamSearchUiModel.players) {
                SearchablePlayerItem(it)
            }
        }

    }
}

@Composable
fun SearchablePlayerItem(
    player: Player
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    width = 0.5.dp,
                    shape = CircleShape,
                    color = ColorFFDCDCDC
                )
                .background(
                    ColorFFFFFFFF
                )
        ) {
            AsyncImage(
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.FillBounds,
                model = player.imageUrl,
                contentDescription = "player",
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 16.dp).width(30.dp),
            text = "${player.backNumber}",
            textAlign = TextAlign.Center,
            color = ColorFF181818,
            style = GnrTypography.body2Medium
        )
        Text(
            modifier = Modifier.weight(1f),
            text = player.name,
            color = ColorFF181818,
            style = GnrTypography.body2Medium
        )
        Text(
            modifier = Modifier.padding(end = 40.dp),
            text = player.positionInitial,
            color = ColorFF181818,
            style = GnrTypography.body2Medium
        )
    }
}