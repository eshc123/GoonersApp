package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.component.MatchLeagueInfo
import com.eshc.goonersapp.core.designsystem.ext.gnrElevatedCardBorder
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF4C68A7
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.ColorFFC3CDE2
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.match.MatchDetail
import com.eshc.goonersapp.core.domain.model.match.MatchDetailType
import com.eshc.goonersapp.core.domain.model.match.getScoreHistoryList

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
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .gnrElevatedCardBorder(10.dp),
        colors = CardDefaults.cardColors(containerColor = ColorFFFFFFFF),
        elevation = 6.dp,
        radius = 10.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MatchLeagueInfo(
                    logoSize = 25.dp,
                    logoPadding = 4.dp,
                    competitionUrl = competitionUrl,
                    competitionName = competitionName,
                    verticalAlignment = Alignment.CenterVertically,
                )
                RecentlyMatchDateStadiumInfo(
                    matchDate = time,
                    stadiumName = location
                )
            }
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
            Spacer(modifier = modifier.size(20.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecentlyGoalHistory(
                    teamId = homeId,
                    matchHistory = matchHistory,
                    modifier = modifier
                        .wrapContentHeight()
                        .weight(1f),
                    alignment = Alignment.Start
                )
                Spacer(modifier = Modifier.width(20.dp))
                RecentlyGoalHistory(
                    teamId = awayId,
                    matchHistory = matchHistory,
                    modifier = modifier
                        .wrapContentHeight()
                        .weight(1f),
                    alignment = Alignment.Start
                )
            }
        }
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
fun RecentlyMatchDateStadiumInfo(
    matchDate: String,
    stadiumName: String,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.End) {
        Text(
            text = matchDate,
            color = ColorFF4C68A7,
            style = GnrTypography.body2Medium
        )
        Spacer(modifier = modifier.size(2.dp))
        Text(
            text = stadiumName,
            color = ColorFF9E9E9E,
            textAlign = TextAlign.End,
            style = GnrTypography.descriptionRegular.copy(
                lineBreak = LineBreak(
                    strategy = LineBreak.Strategy.Balanced,
                    strictness = LineBreak.Strictness.Strict,
                    wordBreak = LineBreak.WordBreak.Default
                )
            )
        )
    }
}

@Composable
fun RecentlyGoalHistory(
    teamId: Int,
    matchHistory: List<MatchDetail>,
    alignment: Alignment.Horizontal,
    modifier: Modifier = Modifier
) {
    val goalHistory = matchHistory.getScoreHistoryList(teamId)

    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = alignment,
        content =  {
            goalHistory.forEach { history ->
                Text(
                    text = history.scoringRecordText,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = GnrTypography.descriptionMedium
                )
                HorizontalDivider(
                    modifier = Modifier.wrapContentWidth(),
                    thickness = 0.5.dp,
                    color = ColorFFDCDCDC
                )
            }
        }
    )
}

@Preview
@Composable
fun RecentlyCard() {
    RecentlyMatchCard(
        competitionUrl = "",
        competitionName = "Premier League",
        time = "24.05.26 WED 18:00",
        location = "The American Express Community Stadium",
        homeId = 19,
        homeUrl = "",
        homeShortName = "ARS",
        homeScore = "3",
        awayId = 236,
        awayUrl = "",
        awayShortName = "BHA",
        awayScore = "1",
        matchHistory = listOf(
            MatchDetail(
                matchId = 222,
                matchDetailId = 222,
                teamId = 19,
                playerId = 2222222,
                playerName = "Antony",
                minute = 90,
                type = MatchDetailType.GOAL,
            ),
            MatchDetail(
                matchId = 222,
                matchDetailId = 222,
                teamId = 236,
                playerId = 2222222,
                playerName = "Gabriel Martinelli",
                minute = 9,
                type = MatchDetailType.OWNGOAL,
            ),
            MatchDetail(
                matchId = 222,
                matchDetailId = 222,
                teamId = 19,
                playerId = 2222222,
                playerName = "Antony",
                minute = 90,
                extraMinute = 5,
                type = MatchDetailType.GOAL,
            )
        )
    )
}