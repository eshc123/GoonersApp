package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFF000000
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun MatchItemResultChip(
    result: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = color,
            contentColor = ColorFF000000
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = result,
                style = GnrTypography.descriptionMedium
            )
        }
    }
}