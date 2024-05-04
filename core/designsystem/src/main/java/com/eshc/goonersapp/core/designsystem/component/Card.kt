package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

@Composable
fun GnrCard(
    shapes: Shape,
    colors: CardColors,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = shapes,
        colors = colors,
        border = border,
        content = content
    )
}

@Composable
fun GnrCard(
    shapeRadius: Dp,
    containerColor: Color,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    GnrCard(
        modifier = modifier,
        shapes = RoundedCornerShape(shapeRadius),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        border = border,
        content = content
    )
}