package com.eshc.goonersapp.feature.team.club

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.team.club.component.ClubDetailHomePage
import com.eshc.goonersapp.feature.team.club.component.ClubDetailImageView
import com.eshc.goonersapp.feature.team.club.component.ClubDetailRecentlyMatchItem
import com.eshc.goonersapp.feature.team.state.ClubDetailUiState

@Composable
fun ClubDetailRoute(
    onBackIconClick: () -> Unit,
    onShowSnackBar : (String) -> Unit,
    clubDetailViewModel: ClubDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val clubDetailUiState by clubDetailViewModel.clubDetail.collectAsStateWithLifecycle()

    LaunchedEffect(clubDetailUiState){
        if(clubDetailUiState is ClubDetailUiState.Error){
            onShowSnackBar("Can't load Data")
        }
    }

    ClubDetailScreen(
        onBackIconClick = onBackIconClick,
        onHomePageUrlClick = { homePageUrl ->
            Intent(Intent.ACTION_VIEW, Uri.parse(homePageUrl)).run {
                context.startActivity(this)
            }
        },
        clubDetailUiState = clubDetailUiState
    )
}

@Composable
fun ClubDetailScreen(
    onBackIconClick: () -> Unit,
    onHomePageUrlClick: (String) -> Unit,
    clubDetailUiState: ClubDetailUiState
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when(clubDetailUiState){
            is ClubDetailUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = { CircularProgressIndicator() }
                )
            }
            is ClubDetailUiState.Success -> {
                ClubDetailImageView(
                    clubImgUrl = clubDetailUiState.teamDetail.team.clubImgUrl,
                    clubName = clubDetailUiState.teamDetail.team.clubName,
                    clubHomeTown = clubDetailUiState.teamDetail.team.clubHomeTown,
                    clubNation = clubDetailUiState.teamDetail.team.clubNationality,
                    clubNationImgUrl = clubDetailUiState.teamDetail.team.clubNationImgUrl,
                    clubFoundedYear = clubDetailUiState.teamDetail.team.clubFoundedYear.toString(),
                    clubStadium = clubDetailUiState.teamDetail.team.stadiumName,
                    clubCoachName =clubDetailUiState.teamDetail.team.manager,
                    clubCaptainName = clubDetailUiState.teamDetail.team.captain
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    if (clubDetailUiState.teamDetail.team.officialWebUrl.isNotEmpty()) {
                        Text(
                            text = "Homepage",
                            modifier = Modifier.padding(top = 50.dp, bottom = 11.dp),
                            style = GnrTypography.subtitleSemiBold
                        )
                        ClubDetailHomePage(
                            homepageUrl = clubDetailUiState.teamDetail.team.officialWebUrl,
                            onHomePageClick = onHomePageUrlClick
                        )
                    }

                    if (clubDetailUiState.teamDetail.team.socialMediaIsNotEmpty()) {
                        Text(
                            text = "Social Media",
                            modifier = Modifier.padding(top = 30.dp),
                            style = GnrTypography.subtitleSemiBold
                        )
                    }

                    if (clubDetailUiState.teamDetail.recentlyMatches.isNotEmpty()) {
                        Text(
                            text = "Recently Result",
                            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp),
                            style = GnrTypography.subtitleSemiBold
                        )
                        Column {
                            clubDetailUiState.teamDetail.recentlyMatches.forEach { match ->
                                ClubDetailRecentlyMatchItem(
                                    matchDate = DateUtil.getYearAndMonthAndDateString(
                                        match.matchDate,
                                        true
                                    ),
                                    homeClubImgUrl = match.homeTeamImageUrl,
                                    homeClubName = match.homeTeamName,
                                    homeClubScore = match.homeScore.toString(),
                                    awayClubImgUrl = match.awayTeamImageUrl,
                                    awayClubName = match.awayTeamName,
                                    awayClubScore = match.awayScore.toString()
                                )
                            }
                        }
                    }
                }
            }
            is ClubDetailUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = { Text(text = "Load Failed") }
                )
            }
        }

    }
}