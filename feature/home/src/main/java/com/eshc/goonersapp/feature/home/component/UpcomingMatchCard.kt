package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.GnrCard
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.component.MatchLeagueInfo
import com.eshc.goonersapp.core.designsystem.ext.gnrElevatedCardBorder
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF4C68A7
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE6EDFC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun UpcomingMatchCard(
    homeUrl: String,
    homeShortName: String,
    awayUrl: String,
    awayShortName: String,
    time: String,
    location: String,
    competitionUrl: String,
    competitionName: String,
    modifier: Modifier = Modifier
) {
    GnrElevatedCard(
        modifier = modifier
            .width(263.dp)
            .height(IntrinsicSize.Max)
            .gnrElevatedCardBorder(10.dp),
        colors = CardDefaults.cardColors(containerColor = ColorFFFFFFFF),
        elevation = 6.dp,
        radius = 10.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MatchLeagueInfo(
                logoSize = 22.dp,
                logoPadding = 5.dp,
                competitionUrl = competitionUrl,
                competitionName = competitionName,
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            UpcomingMatchInfo(
                homeUrl = homeUrl,
                homeShortName = homeShortName,
                awayUrl = awayUrl,
                awayShortName = awayShortName,
                modifier = modifier.width(IntrinsicSize.Max).padding(top = 6.dp)
            )
            Text(
                text = location,
                modifier = modifier.padding(top = 12.dp, bottom = 6.dp),
                color = ColorFF4C68A7,
                style = GnrTypography.descriptionMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            UpcomingDateCard(matchDate = time)
        }
    }
}

@Composable
fun UpcomingMatchInfo(
    homeUrl: String,
    homeShortName: String,
    awayUrl: String,
    awayShortName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            UpcomingHomeTeamInfo(homeUrl = homeUrl, homeShortName = homeShortName)
            Text(
                text = "VS",
                modifier = Modifier.padding(horizontal = 10.dp),
                color = ColorFF10358A,
                style = GnrTypography.subtitleMedium
            )
            UpcomingAwayTeamInfo(awayUrl = awayUrl, awayShortName = awayShortName)
        }
    )
}

@Composable
fun UpcomingHomeTeamInfo(
    homeUrl: String,
    homeShortName: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        content = {
            Text(
                text = homeShortName,
                color = ColorFF181818,
                style = GnrTypography.subtitleMedium
            )
            Spacer(modifier = modifier.size(7.dp))
            AsyncImage(
                model = homeUrl,
                modifier = modifier.size(25.dp),
                contentDescription = "Home Team Logo"
            )
        }
    )
}

@Composable
fun UpcomingAwayTeamInfo(
    awayUrl: String,
    awayShortName: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        content = {
            AsyncImage(
                model = awayUrl,
                modifier = modifier.size(25.dp),
                contentDescription = "Away Team Logo"
            )
            Spacer(modifier = modifier.size(7.dp))
            Text(
                text = awayShortName,
                style = GnrTypography.subtitleMedium
            )
        }
    )
}

@Composable
fun UpcomingDateCard(
    matchDate: String,
    modifier: Modifier = Modifier
) {
    GnrCard(
        shapeRadius = 50.dp,
        containerColor = ColorFFE6EDFC
    ) {
        Text(
            text = matchDate,
            modifier = modifier.padding(horizontal = 12.dp, vertical = 5.dp),
            color = ColorFF10358A,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = GnrTypography.body2Medium
        )
    }
}

@Preview
@Composable
fun PreviewUpcomingCard() {
    UpcomingMatchCard(
        homeUrl = "",
        homeShortName = "ARS",
        awayUrl = "",
        awayShortName = "MCI",
        time = "24.05.28 SUN 00:30",
        location = "The American Express Community Stadium",
        competitionUrl = "",
        competitionName = "premier League"
    )
}