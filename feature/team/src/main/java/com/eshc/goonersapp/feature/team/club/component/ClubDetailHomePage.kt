package com.eshc.goonersapp.feature.team.club.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.iconpack.IcHomeUnselected
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF555555
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun ClubDetailHomePage(
    homepageUrl: String,
    onHomePageClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable(onClick = { onHomePageClick(homepageUrl) }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(color = ColorFF10358A),
            contentAlignment = Alignment.Center,
            content = {
                Icon(
                    imageVector = IconPack.IcHomeUnselected,
                    contentDescription = null,
                    modifier = Modifier.size(12.dp),
                    tint = ColorFFFFFFFF
                )
            }
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = homepageUrl,
            color = ColorFF555555,
            style = GnrTypography.body2Medium
        )
    }
}