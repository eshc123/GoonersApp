package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    backgroundColor : Color,
    imageContent : @Composable () -> Unit
){
    Card(
        modifier = modifier.wrapContentSize(),
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Box(
            modifier = Modifier.padding(4.dp)
        ) {
            imageContent()
        }
    }
}