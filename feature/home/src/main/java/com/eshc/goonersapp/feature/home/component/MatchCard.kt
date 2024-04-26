package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF4C68A7
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.ColorFFC3CDE2
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF7F9FF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.match.MatchDetail

@Composable
fun RecentlyMatchCard(
    competitionUrl: String,
    competitionName: String,
    time: String,
    location: String,
    homeId: Int,
    homeUrl: String,
    homeShortName: String,
    homeScore: String,
    awayId: Int,
    awayUrl: String,
    awayShortName: String,
    awayScore: String,
    matchHistory: List<MatchDetail>,
    modifier: Modifier = Modifier
) {
    val annotatedScore = buildAnnotatedString {
        withStyle(style = SpanStyle(ColorFF10358A)) { append("$homeScore ") }
        withStyle(style = SpanStyle(ColorFFC3CDE2)) { append(":") }
        withStyle(style = SpanStyle(ColorFF10358A)) { append(" $awayScore") }
    }

    GnrElevatedCard(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .border(
                width = 1.dp,
                color = ColorFFF5F5F5,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        radius = 10.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MatchLeagueInfo(
                    logoSize = 25.dp,
                    logoPadding = 4.dp,
                    competitionUrl = competitionUrl,
                    competitionName = competitionName,
                    verticalAlignment = Alignment.CenterVertically,
                )
                Row {
                    Text(
                        text = time,
                        color = ColorFF4C68A7,
                        style = GnrTypography.descriptionRegular
                    )
                    Spacer(modifier = modifier.size(5.dp))
                    Text(
                        text = location,
                        color = ColorFF4C68A7,
                        style = GnrTypography.descriptionMedium
                    )
                }
            }
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    RecentlyTeamInfo(
                        teamImgUrl = homeUrl,
                        teamShortName = homeShortName,
                        teamSide = "Home"
                    )
                    Text(
                        text = annotatedScore,
                        style = GnrTypography.heading1Bold
                    )
                    RecentlyTeamInfo(
                        teamImgUrl = awayUrl,
                        teamShortName = awayShortName,
                        teamSide = "Away"
                    )
                }
            )
            Spacer(modifier = modifier.size(20.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    RecentlyGoalHistory(
                        teamId = homeId,
                        matchHistory = matchHistory,
                        modifier = modifier
                            .wrapContentHeight()
                            .weight(1f)
                    )
                    RecentlyGoalHistory(
                        teamId = awayId,
                        matchHistory = matchHistory,
                        modifier = modifier
                            .wrapContentHeight()
                            .weight(1f)
                    )
                }
            )
        }
    }
}

@Composable
fun UpcomingMatchCard(
    modifier: Modifier = Modifier,
    homeUrl: String,
    homeShortName: String,
    awayUrl: String,
    awayShortName: String,
    time: String,
    location: String,
    competitionUrl: String,
    competitionName: String
) {
    GnrElevatedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        radius = 10.dp,
        modifier = modifier
            .width(263.dp)
            .height(131.dp)
            .border(
                width = 1.dp,
                color = ColorFFF5F5F5,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MatchLeagueInfo(
                logoSize = 22.dp,
                logoPadding = 4.dp,
                competitionUrl = competitionUrl,
                competitionName = competitionName,
                modifier = modifier.fillMaxWidth()
            )
            UpcomingMatchInfo(
                homeUrl = homeUrl,
                homeShortName = homeShortName,
                awayUrl = awayUrl,
                awayShortName = awayShortName,
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            UpcomingMatchDateInfo(
                time = time,
                location = location,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun MatchLeagueInfo(
    logoSize: Dp,
    logoPadding: Dp,
    competitionUrl: String,
    competitionName: String,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .border(
                    width = 0.5.dp,
                    shape = CircleShape,
                    color = ColorFFDCDCDC
                ),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = ColorFFF5F5F5),
            content = {
                Box(
                    modifier = Modifier
                        .padding(logoPadding)
                        .size(logoSize),
                    content = { AsyncImage(model = competitionUrl, contentDescription = "League Logo") }
                )
            }
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = competitionName,
            color = ColorFF181818,
            style = GnrTypography.descriptionSemiBold
        )
    }
}

@Composable
fun RecentlyTeamInfo(
    teamImgUrl: String,
    teamShortName: String,
    teamSide: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = teamImgUrl,
            contentDescription = "Home Team Logo",
            modifier = modifier.size(50.dp)
        )
        Text(
            text = teamShortName,
            color = ColorFF181818,
            style = GnrTypography.body1SemiBold
        )
        Text(
            text = teamSide,
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionRegular
        )
    }
}

@Composable
fun RecentlyGoalHistory(
    teamId: Int,
    matchHistory: List<MatchDetail>,
    modifier: Modifier = Modifier
) {
    val goalHistory = matchHistory.let { detail ->
        detail
            .filter { history -> history.type == "GOAL" }
            .filter { history -> history.teamId == teamId }
    }

    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.Start,
        content =  {
            goalHistory.forEach { history ->
                Spacer(modifier = Modifier.size(3.dp))
                Text(
                    text = "${history.playerName} (${history.minute}`)",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = GnrTypography.descriptionMedium
                )
                Spacer(modifier = Modifier.size(1.5.dp))
                HorizontalDivider(
                    modifier = Modifier.wrapContentWidth(),
                    thickness = 0.5.dp,
                    color = ColorFFDCDCDC
                )
            }
        }
    )
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
            Text(text = "VS", color = ColorFF10358A, style = GnrTypography.subtitleMedium)
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
            AsyncImage(
                model = homeUrl,
                modifier = modifier.size(30.dp),
                contentDescription = "Home Team Logo"
            )
            Spacer(modifier = modifier.size(10.dp))
            Text(
                text = homeShortName,
                style = GnrTypography.subtitleMedium
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
            Text(
                text = awayShortName,
                style = GnrTypography.subtitleMedium
            )
            Spacer(modifier = modifier.size(10.dp))
            AsyncImage(
                model = awayUrl,
                modifier = modifier.size(30.dp),
                contentDescription = "Away Team Logo"
            )
        }
    )
}

@Composable
fun UpcomingMatchDateInfo(
    time: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.wrapContentHeight(),
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorFFF7F9FF,
            contentColor = ColorFF4C68A7
        ),
        border = BorderStroke(
            width = 0.5.dp,
            color = ColorFFC3CDE2
        )
    ) {
        Row(
            modifier = modifier.padding(vertical = 3.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            content = {
                Text(
                    text = time,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = GnrTypography.body2Medium
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = location,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = GnrTypography.body2Medium
                )
            }
        )
    }
}