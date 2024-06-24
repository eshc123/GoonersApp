package com.eshc.goonersapp.feature.team.club

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.eshc.goonersapp.core.designsystem.component.GnrHorizontalDivider
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.team.club.component.ClubDetailHomePageRow
import com.eshc.goonersapp.feature.team.club.component.ClubDetailHeaderView
import com.eshc.goonersapp.feature.team.club.component.ClubDetailRecentlyMatchItem
import com.eshc.goonersapp.feature.team.club.component.ClubDetailSocialMediaRow
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
        if(clubDetailUiState is ClubDetailUiState.Error) {
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
    when(clubDetailUiState){
        is ClubDetailUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
                content = { CircularProgressIndicator() }
            )
        }
        is ClubDetailUiState.Success -> {
            val scrollState: ScrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                ClubDetailHeaderView(
                    clubImgUrl = clubDetailUiState.teamDetail.team.clubImgUrl,
                    clubName = clubDetailUiState.teamDetail.team.clubName,
                    clubHomeTown = clubDetailUiState.teamDetail.team.clubHomeTown,
                    clubNation = clubDetailUiState.teamDetail.team.clubNationality,
                    clubNationImgUrl = clubDetailUiState.teamDetail.team.clubNationImgUrl,
                    clubFoundedYear = clubDetailUiState.teamDetail.team.clubFoundedYear.toString(),
                    clubStadium = clubDetailUiState.teamDetail.team.stadiumName,
                    clubCoachName = clubDetailUiState.teamDetail.team.manager,
                    clubCaptainName = clubDetailUiState.teamDetail.team.captain,
                    onBackIconClick = onBackIconClick
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    if (clubDetailUiState.teamDetail.officialWebUrlIsNotEmpty()) {
                        Text(
                            text = "Homepage",
                            modifier = Modifier.padding(top = 50.dp, bottom = 11.dp),
                            style = GnrTypography.subtitleSemiBold
                        )
                        ClubDetailHomePageRow(
                            homepageUrl = clubDetailUiState.teamDetail.team.officialWebUrl,
                            onHomePageClick = onHomePageUrlClick
                        )
                    }

                    if (clubDetailUiState.teamDetail.socialMediaIsNotEmpty()) {
                        Text(
                            text = "Social Media",
                            modifier = Modifier.padding(top = 30.dp),
                            style = GnrTypography.subtitleSemiBold
                        )
                        ClubDetailSocialMediaRow(
                            isInstagramNotEmpty = clubDetailUiState.teamDetail.instagramIsNotEmpty(),
                            isFaceBookNotEmpty = clubDetailUiState.teamDetail.faceBookIsNotEmpty(),
                            isXNotEmpty = clubDetailUiState.teamDetail.xIsNotEmpty(),
                            onInstagramLogoClick = { /* Nothing Implemented */ },
                            onFaceBookLogoClick = { /* Nothing Implemented */ },
                            onXLogoClick = { /* Nothing Implemented */ }
                        )
                    }

                    if (clubDetailUiState.teamDetail.matchesIsNotEmpty()) {
                        Text(
                            text = "Recently Result",
                            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp),
                            style = GnrTypography.subtitleSemiBold
                        )
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            clubDetailUiState
                                .teamDetail
                                .recentlyMatches
                                .forEachIndexed { index, match ->
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

                                    if (index != clubDetailUiState.teamDetail.matchesLastIndex()) {
                                        GnrHorizontalDivider()
                                    }
                                }
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