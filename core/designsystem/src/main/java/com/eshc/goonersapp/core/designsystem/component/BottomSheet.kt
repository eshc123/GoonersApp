package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GnrBottomSheet(
    onDismiss: () -> Unit,
    content : @Composable () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = modalBottomSheetState,
        shape = RoundedCornerShape(
            topStart = 35.dp,
            topEnd = 35.dp
        ),
        containerColor = ColorFFFFFFFF,
        windowInsets = WindowInsets.displayCutout
    ) {
        Column(
            modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
        ) {
            content()
        }
    }
}