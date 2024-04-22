package com.eshc.goonersapp.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.home.component.DashboardCard
import com.eshc.goonersapp.feature.home.component.RecentlyMatchCard
import com.eshc.goonersapp.feature.home.component.UpcomingMatchCard

@Composable
fun HomeRoute(
    topBar : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    onShowSnackbar : (String) -> Unit
) {
    Scaffold(
        topBar = {
            topBar()
        },
        bottomBar = {
            bottomBar()
        }
    ) { padding ->
        HomeScreen(
            modifier = Modifier.padding(padding),
            viewModel = viewModel
        )
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    val upcomingMatches by viewModel.upcomingMatches.collectAsStateWithLifecycle()
    val recentlyMatch by viewModel.recentlyMatch.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Team Dashboard",
                style = GnrTypography.subtitleMedium
            )
            DashboardCard()
        }

        item {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Upcoming Matches",
                style = GnrTypography.subtitleMedium,
                color = Color.Black,
            )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = upcomingMatches,
                    key = { upcomingMatches -> upcomingMatches.matchId }
                ) { matches ->
                    UpcomingMatchCard(
                        homeUrl = matches.homeTeamImageUrl,
                        homeShortName = matches.homeTeamNickname,
                        awayUrl = matches.awayTeamImageUrl,
                        awayShortName = matches.awayTeamNickname,
                        time = DateUtil.getYearAndMonthAndDateAndTimeString(matches.matchDate),
                        location = matches.stadiumName ?: "",
                        competitionUrl = matches.leagueImageUrl,
                        competitionName = "Premier League"
                    )
                }
            }
        }

        recentlyMatch?.let { match ->
            item {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Recently Result",
                    style = GnrTypography.subtitleMedium,
                    color = Color.Black,
                )
                RecentlyMatchCard(
                    competitionUrl = match.match.leagueImageUrl,
                    competitionName = "Premier league",
                    time = DateUtil.getYearAndMonthAndDateAndTimeString(match.match.matchDate),
                    location = match.match.stadiumName,
                    homeId = match.match.homeTeamId,
                    homeUrl = match.match.homeTeamImageUrl,
                    homeShortName = match.match.homeTeamNickname,
                    homeScore = match.match.homeScore.toString(),
                    awayId = match.match.awayTeamId,
                    awayUrl = match.match.awayTeamImageUrl,
                    awayShortName = match.match.awayTeamNickname,
                    awayScore = match.match.awayScore.toString(),
                    matchHistory = match.matchDetail
                )
            }
        }

    }
}

