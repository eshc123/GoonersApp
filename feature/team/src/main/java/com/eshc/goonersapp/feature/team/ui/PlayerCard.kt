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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.network.model.RemotePlayer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquadPlayerCard(
    player: RemotePlayer,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .width(186.dp)
            .height(216.dp),
        onClick = onClick,
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
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 36.sp,
                lineHeight = 32.sp
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
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    textAlign = TextAlign.Start,
                    text = player.name,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 26.sp,
                    lineHeight = 26.sp
                )

            }

        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlayerHeaderImage(
    imageUrl: String,
    height: Dp
) {
    GlideImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        contentScale = ContentScale.Crop,
        model = imageUrl,
        contentDescription = null
    ) {
        it.diskCacheStrategy(
            DiskCacheStrategy.ALL
        )
    }
}
