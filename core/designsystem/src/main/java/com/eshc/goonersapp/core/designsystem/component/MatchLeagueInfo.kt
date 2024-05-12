package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun MatchLeagueInfo(
    logoSize: Dp,
    logoPadding: Dp,
    competitionUrl: String,
    competitionName: String,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .border(
                    width = 0.5.dp,
                    shape = CircleShape,
                    color = ColorFFDCDCDC
                ),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = ColorFFF5F5F5),
            content = {
                Box(
                    modifier = Modifier
                        .padding(logoPadding)
                        .size(logoSize),
                    content = { AsyncImage(model = competitionUrl, contentDescription = "League Logo") }
                )
            }
        )
        Spacer(modifier = Modifier.size(7.dp))
        Text(
            text = competitionName,
            color = ColorFF181818,
            style = GnrTypography.descriptionSemiBold
        )
    }
}