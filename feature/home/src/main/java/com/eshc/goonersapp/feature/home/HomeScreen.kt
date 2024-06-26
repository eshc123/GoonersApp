package com.eshc.goonersapp.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.home.component.DashboardCard
import com.eshc.goonersapp.feature.home.component.RecentlyMatchCard
import com.eshc.goonersapp.feature.home.component.UpcomingMatchCard
import com.eshc.goonersapp.feature.home.state.DashBoardUiState
import com.eshc.goonersapp.feature.home.state.RecentlyResultUiState
import com.eshc.goonersapp.feature.home.state.UpcomingMatchesUiState

@Composable
fun HomeRoute(
    topBar : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    onShowSnackbar : (String) -> Unit
) {
    val dashBoardUiState by viewModel.teamDashBoardUiStateFlow.collectAsStateWithLifecycle()
    val upcomingMatchesUiState by viewModel.upcomingMatchesUiStateFlow.collectAsStateWithLifecycle()
    val recentlyResultUiState by viewModel.recentlyResultUiStateFlow.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { topBar() },
        bottomBar = { bottomBar() }
    ) { padding ->
        HomeScreen(
            modifier = Modifier.padding(padding),
            dashBoardUiState = dashBoardUiState,
            upcomingMatchesUiState = upcomingMatchesUiState,
            recentlyResultUiState = recentlyResultUiState
        )
    }
}

@Composable
fun HomeScreen(
    dashBoardUiState: DashBoardUiState,
    upcomingMatchesUiState: UpcomingMatchesUiState,
    recentlyResultUiState: RecentlyResultUiState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 30.dp)
    ) {
        item {
            Text(
                text = "Team Dashboard",
                modifier = Modifier.padding(start = 15.dp),
                color = ColorFF181818,
                style = GnrTypography.subtitleMedium
            )
            when (dashBoardUiState) {
                is DashBoardUiState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(208.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is DashBoardUiState.Success -> {
                    DashboardCard(dashBoardUiState.data)
                }
                is DashBoardUiState.Failed -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(208.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Rank List cannot be loaded.",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.LightGray,
                        )
                    }
                }
                is DashBoardUiState.Error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(208.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Error! ${dashBoardUiState.throwable}",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.LightGray,
                        )
                    }
                }
            }
        }

        item {
            Text(
                text = "Upcoming Matches",
                modifier = Modifier.padding(start = 15.dp, top = 55.dp),
                color = ColorFF181818,
                style = GnrTypography.subtitleMedium,
            )
            when (upcomingMatchesUiState) {
                is UpcomingMatchesUiState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(131.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is UpcomingMatchesUiState.Success -> {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            items = upcomingMatchesUiState.data,
                            key = { upcomingMatches -> upcomingMatches.id }
                        ) { matches ->
                            UpcomingMatchCard(
                                homeUrl = matches.homeTeamImageUrl,
                                homeShortName = matches.homeTeamNickname,
                                awayUrl = matches.awayTeamImageUrl,
                                awayShortName = matches.awayTeamNickname,
                                time = DateUtil.getYearAndMonthAndDateAndDayAndTimeString(matches.matchDate),
                                location = if (matches.stadiumName == "null") "" else matches.stadiumName,
                                competitionUrl = matches.leagueImageUrl,
                                competitionName = "Premier League"
                            )
                        }
                    }
                }
                is UpcomingMatchesUiState.Failed -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(131.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Upcoming Matches cannot be loaded.",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.LightGray,
                        )
                    }
                }
                is UpcomingMatchesUiState.Error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(131.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Error! ${upcomingMatchesUiState.throwable}",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.LightGray,
                        )
                    }
                }
            }
        }

        item {
            Text(
                modifier = Modifier.padding(start = 15.dp, top = 55.dp),
                text = "Recently Result",
                style = GnrTypography.subtitleMedium,
                color = Color.Black,
            )
            when (recentlyResultUiState) {
                is RecentlyResultUiState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(273.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is RecentlyResultUiState.Success -> {
                    recentlyResultUiState.data?.let { match ->
                        RecentlyMatchCard(
                            competitionUrl = match.match.leagueImageUrl,
                            competitionName = "Premier league",
                            time = DateUtil.getYearAndMonthAndDateAndDayAndTimeString(match.match.matchDate),
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
                is RecentlyResultUiState.Failed -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(273.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Recently Result cannot be loaded.",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.LightGray,
                        )
                    }
                }
                is RecentlyResultUiState.Error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(273.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Error! ${recentlyResultUiState.throwable}",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.LightGray,
                        )
                    }
                }
            }
        }
    }
}