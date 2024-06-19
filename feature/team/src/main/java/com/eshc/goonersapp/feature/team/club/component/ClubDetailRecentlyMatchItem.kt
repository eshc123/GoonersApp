package com.eshc.goonersapp.feature.team.club.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.ColorFF4C68A7
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun ClubDetailRecentlyMatchItem(
    matchDate: String,
    homeClubImgUrl: String,
    homeClubName: String,
    homeClubScore: String,
    awayClubImgUrl: String,
    awayClubName: String,
    awayClubScore: String
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = matchDate,
            color = ColorFF4C68A7,
            modifier = Modifier.weight(0.2f),
            style = GnrTypography.descriptionMedium
        )
        Spacer(modifier = Modifier.width(35.dp))
        ClubColumn(
            homeClubImgUrl = homeClubImgUrl,
            homeClubName = homeClubName,
            homeClubScore = homeClubScore,
            awayClubImgUrl = awayClubImgUrl,
            awayClubName = awayClubName,
            awayClubScore = awayClubScore,
            modifier = Modifier.weight(1f).wrapContentHeight()
        )
    }
}

@Composable
fun ClubColumn(
    homeClubImgUrl: String,
    homeClubName: String,
    homeClubScore: String,
    awayClubImgUrl: String,
    awayClubName: String,
    awayClubScore: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Club(
            homeClubImgUrl,
            homeClubName,
            homeClubScore,
            Modifier.padding(top = 12.dp)
        )
        Spacer(modifier = Modifier.size(4.dp))
        Club(
            awayClubImgUrl,
            awayClubName,
            awayClubScore,
            Modifier.padding(bottom = 12.dp)
        )
    }
}

@Composable
fun Club(
    clubImgUrl: String,
    clubName: String,
    score: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(22.dp)
                .clip(CircleShape)
                .border(1.dp, color = ColorFFF5F5F5, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = clubImgUrl,
                modifier = Modifier
                    .padding(2.dp)
                    .matchParentSize(),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.size(7.dp))
        Text(
            text = clubName,
            style = GnrTypography.descriptionMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = score,
            style = GnrTypography.body1SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMatchItem() {
    Column {
        ClubDetailRecentlyMatchItem(
            matchDate = "24.03.31",
            homeClubName = "Arsenal",
            homeClubScore = "2",
            homeClubImgUrl = "",
            awayClubName = "Man City",
            awayClubImgUrl = "",
            awayClubScore = "1"
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = ColorFFDCDCDC
        )
        ClubDetailRecentlyMatchItem(
            matchDate = "24.05.20",
            homeClubName = "Arsenal",
            homeClubScore = "2",
            homeClubImgUrl = "",
            awayClubName = "Man City",
            awayClubImgUrl = "",
            awayClubScore = "1"
        )
    }
}