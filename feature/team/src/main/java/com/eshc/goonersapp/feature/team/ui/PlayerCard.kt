package com.eshc.goonersapp.feature.team.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player

@Composable
fun SquadPlayerCard(
    player: Player,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .width(137.dp)
                .height(153.dp),
            onClick = {
                onClick(player.id.toString())
            },
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ColorFFF5F5F5)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth().aspectRatio(1f)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                    model = player.imageUrl,
                    contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp)
                        .alpha(0.3f),
                    textAlign = TextAlign.Start,
                    text = player.backNumber.toString(),
                    style = GnrTypography.heading1Medium.copy(
                        fontSize = 30.sp
                    ),
                    color = ColorFF181818,
                )
            }
        }

        Text(
            modifier = Modifier.padding(top = 8.dp).fillMaxWidth().height(36.dp),
            textAlign = TextAlign.Center,
            text = player.name,
            style = GnrTypography.body1Medium.copy(
                lineBreak = LineBreak(
                    strategy = LineBreak.Strategy.Balanced,
                    strictness = LineBreak.Strictness.Strict,
                    wordBreak = LineBreak.WordBreak.Default
                )
            ),
            color = ColorFF181818,
        )
    }
}