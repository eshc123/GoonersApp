package com.eshc.goonersapp.feature.team.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.component.LargeDropdownMenu
import com.eshc.goonersapp.core.designsystem.component.TopBar

@Composable
fun TeamHistoryScreen(
    onClick : (String) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            title = "HISTORY"
        )

    }
}