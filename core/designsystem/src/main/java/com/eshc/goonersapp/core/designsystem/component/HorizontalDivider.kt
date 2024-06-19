package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC

@Composable
fun GnrHorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = ColorFFDCDCDC,
    thickness: Dp = 1.dp
) {
    HorizontalDivider(modifier, thickness, color)
}