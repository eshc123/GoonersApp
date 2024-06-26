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
import com.eshc.goonersapp.core.designsystem.R
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF

@Composable
fun ClubDetailSocialMediaRow(
    isInstagramNotEmpty: Boolean,
    isFaceBookNotEmpty: Boolean,
    isXNotEmpty: Boolean,
    onInstagramLogoClick: () -> Unit,
    onFaceBookLogoClick: () -> Unit,
    onXLogoClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isInstagramNotEmpty) {
            Image(
                painter = painterResource(id = R.drawable.ic_insta),
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onInstagramLogoClick),
                contentScale = ContentScale.Crop,
                contentDescription = "Club Instagram Image"
            )
        }

        if (isFaceBookNotEmpty) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                modifier = Modifier
                    .size(42.dp)
                    .background(color = ColorFFFFFFFF, shape = CircleShape)
                    .clip(CircleShape)
                    .clickable(onClick = onFaceBookLogoClick),
                contentScale = ContentScale.Crop,
                contentDescription = "Club facebook Image"
            )
        }

        if (isXNotEmpty) {
            Image(
                painter = painterResource(id = R.drawable.ic_x),
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onXLogoClick),
                contentScale = ContentScale.Crop,
                contentDescription = "Club X Image"
            )
        }
    }
}