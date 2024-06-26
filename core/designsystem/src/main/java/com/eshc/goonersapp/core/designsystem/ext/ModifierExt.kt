package com.eshc.goonersapp.core.designsystem.ext

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5

fun Modifier.gnrElevatedCardBorder(
    round : Dp,
    color : Color = ColorFFF5F5F5,
) = this.then(
    Modifier.border(
        width = 1.dp,
        color = color,
        shape = RoundedCornerShape(round)
    )
)