package com.eshc.goonersapp.feature.team.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.eshc.goonersapp.core.designsystem.component.GnrTopBar

@Composable
fun TeamSearchRootScreen(
    onClick: (String) -> Unit,
    onBackIconClick: () -> Unit,
    onShowSnackbar: (String) -> Unit
) {
    Scaffold(
        topBar = {
            GnrTopBar(
                title = "Search",
                onBackIconClick = onBackIconClick
            )
        }
    ) { paddingValues ->
        TeamSearchScreen(
            onClick = onClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun TeamSearchScreen(
    onClick : (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        /* TODO("Not yet Implemented") */
    }
}