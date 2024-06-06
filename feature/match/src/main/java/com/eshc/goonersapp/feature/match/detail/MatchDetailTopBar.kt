package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.match.model.MatchUiModel

@Composable
fun MatchDetailTopBar(
    match : MatchUiModel
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(7.dp, alignment = Alignment.Start)
    ) {
        AsyncImage(
            modifier = Modifier.size(25.dp),
            model = match.leagueImageUrl,
            contentDescription = "League Logo"
        )
        Text(
            text = match.getMatchTitle(),
            style = GnrTypography.subtitleSemiBold,
            color = ColorFF181818,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}