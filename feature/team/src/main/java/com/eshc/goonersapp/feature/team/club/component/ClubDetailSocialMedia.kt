package com.eshc.goonersapp.feature.team.club.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ClubDetailSocialMedia() {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = com.eshc.goonersapp.core.designsystem.R.drawable.ic_insta),
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape),
            contentDescription = ""
        )
        Icon(
            painter = painterResource(id = com.eshc.goonersapp.core.designsystem.R.drawable.ic_facebook),
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape),
            contentDescription = ""
        )
        Icon(
            painter = painterResource(id = com.eshc.goonersapp.core.designsystem.R.drawable.ic_x),
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape),
            contentDescription = ""
        )
    }
}