package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

@Composable
fun GnrElevatedCard(
    shape: Shape,
    colors: CardColors,
    elevation: CardElevation,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    ElevatedCard(
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = elevation,
        content = content
    )
}

@Composable
fun GnrElevatedCard(
    colors: CardColors,
    radius: Dp,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    GnrElevatedCard(
        shape = RoundedCornerShape(radius),
        colors = colors,
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier,
        content = content
    )
}

@Composable
fun GnrElevatedCard(
    colors: CardColors,
    radius: Dp,
    elevation: Dp,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    GnrElevatedCard(
        shape = RoundedCornerShape(radius),
        colors = colors,
        elevation = CardDefaults.elevatedCardElevation(elevation),
        modifier = modifier,
        content = content
    )
}