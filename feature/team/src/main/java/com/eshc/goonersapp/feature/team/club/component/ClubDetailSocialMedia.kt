package com.eshc.goonersapp.feature.team.club.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF

@Composable
fun ClubDetailSocialMedia(
    onClickInstagram: () -> Unit,
    onClickFaceBook: () -> Unit,
    onClickX: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = com.eshc.goonersapp.core.designsystem.R.drawable.ic_insta),
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .clickable(onClick = onClickInstagram),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = com.eshc.goonersapp.core.designsystem.R.drawable.ic_facebook),
            modifier = Modifier
                .size(42.dp)
                .background(color = ColorFFFFFFFF, shape = CircleShape)
                .clip(CircleShape)
                .clickable(onClick = onClickFaceBook),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = com.eshc.goonersapp.core.designsystem.R.drawable.ic_x),
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .clickable(onClick = onClickX),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}