package com.eshc.goonersapp.feature.match.component.formation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.match.PlayerLineup

@Composable
fun RowScope.LineUpPlayerCard(
    player: PlayerLineup,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(ColorFFDCDCDC),
            contentScale = ContentScale.Crop,
            model = player.playerImageUrl,
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(top = 2.dp)
                .height(24.dp),
            text = player.playerName,
            style = GnrTypography.descriptionMedium.copy(
                lineHeight = 11.sp
            ),
            maxLines = 2,
            textAlign = TextAlign.Center,
            color = ColorFFDCDCDC

        )
    }
}
