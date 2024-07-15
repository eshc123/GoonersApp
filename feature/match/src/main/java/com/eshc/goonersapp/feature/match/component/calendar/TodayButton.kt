package com.eshc.goonersapp.feature.match.component.calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.component.GnrTextButton
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF889AC4
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE6EDFC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun TodayButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    GnrTextButton(
        text = "Today",
        onClick = onClick,
        modifier = modifier,
        textStyle = GnrTypography.body2Medium,
        containerColor = ColorFFE6EDFC,
        contentColor = ColorFF10358A,
        round = 5.dp,
        borderStroke = BorderStroke(1.dp, ColorFF889AC4),
        contentPaddingValues = PaddingValues(0.dp)
    )
}
