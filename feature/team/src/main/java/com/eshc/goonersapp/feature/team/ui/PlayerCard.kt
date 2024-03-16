package com.eshc.goonersapp.feature.team.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.player.Player

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquadPlayerCard(
    player: Player,
    onClick: (String) -> Unit,
) {
    Card(
        modifier = Modifier
            .width(186.dp)
            .height(216.dp),
        onClick = {
           onClick(player.id.toString())
        },
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            PlayerHeaderImage(
                player.imageUrl,
                186.dp
            )

            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 8.dp)
                    .alpha(0.7f),
                textAlign = TextAlign.Start,
                text = player.backNumber.toString(),
                style = MaterialTheme.typography.displaySmall,
                color = Color.White,
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 0.2f,
                            endY = 170f
                        ),
                        alpha = 0.90f
                    ),
                contentAlignment = Alignment.BottomStart
            ) {

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp, end = 8.dp),
                    textAlign = TextAlign.Start,
                    text = player.name,
                    style = MaterialTheme.typography.headlineMedium,
                    lineHeight = 28.sp,
                    color = Color.White,
                )

            }

        }
    }
}

@Composable
fun PlayerHeaderImage(
    imageUrl: String,
    height: Dp
) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        contentScale = ContentScale.Crop,
        model = imageUrl,
        contentDescription = null
    )
}
