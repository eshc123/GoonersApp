package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.state.UiState
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrTabItem
import com.eshc.goonersapp.core.designsystem.component.GnrTopBar
import com.eshc.goonersapp.core.designsystem.component.MatchLeagueInfo
import com.eshc.goonersapp.core.designsystem.iconpack.IcTalk
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.core.designsystem.theme.ColorFFC3CDE2
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.match.MatchDetail
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import com.eshc.goonersapp.core.domain.model.match.getScoreHistoryList
import com.eshc.goonersapp.feature.match.model.MatchUiModel
import com.eshc.goonersapp.feature.match.state.MatchDetailUiState

@Composable
fun MatchDetailRootScreen(
    onBackIconClick: () -> Unit,
    onShowSnackbar: (String) -> Unit,
    onClickChat: (MatchUiModel) -> Unit,
    viewModel: MatchDetailViewModel = hiltViewModel(),
) {
    val matchData by viewModel.matchDetailUiState.collectAsStateWithLifecycle()
    val lineup by viewModel.lineupUiState.collectAsStateWithLifecycle()
    val matchInformation by viewModel.matchInformationState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            GnrTopBar(
                title = "",
                onBackIconClick = onBackIconClick,
                content = {  }
            )
        }
    ) { paddingValues ->
        MatchDetailScreen(
            matchDetailUiState = matchData,
            lineupUiState = lineup,
            matchInformationState = matchInformation,
            onClickChat = onClickChat,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}

@Composable
fun MatchDetailScreen(
    matchDetailUiState: MatchDetailUiState,
    lineupUiState: UiState<MatchLineup>,
    matchInformationState : UiState<MatchInformation>,
    onClickChat: (MatchUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(DetailTab.SUMMARY) }
    val match = matchDetailUiState.match
    val matchDetail = matchDetailUiState.matchDetailState

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MatchLeagueInfo(
                        logoSize = 25.dp,
                        logoPadding = 4.dp,
                        competitionUrl = match.leagueImageUrl,
                        competitionName = "Premier league",
                        verticalAlignment = Alignment.CenterVertically,
                    )

                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = DateUtil.getYearAndMonthAndDateAndDayAndTimeString(match.matchDate),
                            style = GnrTypography.body1SemiBold,
                            color = ColorFF10358A,
                        )
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = match.stadiumName,
                            style = GnrTypography.body2Regular,
                            color = ColorFF777777,
                        )
                    }
                }

                val annotatedScore = if (match.isFinished) buildAnnotatedString {
                    withStyle(style = SpanStyle(ColorFF10358A)) { append("${match.homeScore} ") }
                    withStyle(style = SpanStyle(ColorFFC3CDE2)) { append(":") }
                    withStyle(style = SpanStyle(ColorFF10358A)) { append(" ${match.awayScore}") }
                } else buildAnnotatedString {
                    withStyle(style = SpanStyle(ColorFF10358A)) { append("  vs  ") }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TeamLogoImageBox(
                        teamLogoImageUrl = match.homeTeamImageUrl
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = annotatedScore,
                        style = GnrTypography.heading1Bold,
                    )

                    TeamLogoImageBox(
                        teamLogoImageUrl = match.awayTeamImageUrl
                    )
                }

            }

            item {
                when(matchDetail){
                    is UiState.Success -> {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 20.dp
                                )
                                .height(IntrinsicSize.Min),
                            horizontalArrangement = Arrangement.Center,
                            content = {
                                MatchScoredHistory(
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.End,
                                    matchScoreHistoryList = matchDetail.data.getScoreHistoryList(match.homeTeamId)
                                )
                                VerticalDivider(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(horizontal = 12.dp)
                                )
                                MatchScoredHistory(
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.Start,
                                    matchScoreHistoryList = matchDetail.data.getScoreHistoryList(match.awayTeamId)
                                )
                            }
                        )
                    }
                    is UiState.Loading -> {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ){
                            CircularProgressIndicator()
                        }

                    }
                    else -> {

                    }
                }


                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .fillMaxWidth(), thickness = 8.dp, color = Color(0xFFE4E4E4)
                )
            }


            item {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    DetailTab.entries.forEach {
                        GnrTabItem(
                            modifier = Modifier.weight(1f),
                            tabTitle = it.name,
                            isSelected = selectedTab == it,
                            onSelect = {
                                selectedTab = it
                            }
                        )
                    }
                }
            }

            item {
                when (selectedTab) {
                    DetailTab.SUMMARY -> {
                        SummaryScreen(
                            lineupUiState = lineupUiState,
                            matchInformationState = matchInformationState
                        )
                    }
                    DetailTab.COMMENT -> { /* TODO("Not yet implemented") */ }
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(18.dp),
            onClick = {
                onClickChat(match)
            }
        ) {
            Icon(
                imageVector = IconPack.IcTalk,
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun RowScope.MatchScoredHistory(
    matchScoreHistoryList: List<MatchDetail>,
    horizontalAlignment: Alignment.Horizontal,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = horizontalAlignment
    ) {
        matchScoreHistoryList.forEach { history ->
            Text(
                text = history.scoringRecordText,
                color = ColorFF10358A,
                style = GnrTypography.descriptionMedium
            )
        }
    }
}

@Composable
fun TeamLogoImageBox(
    teamLogoImageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(88.dp)
            .clip(CircleShape)
            .background(
                ColorFFF5F5F5
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 3.dp,
                    shape = CircleShape
                )
                .size(72.dp)
                .clip(CircleShape)
                .background(
                    ColorFFFFFFFF
                ),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(0.65f),
                model = teamLogoImageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

enum class DetailTab {
    SUMMARY, COMMENT
}
