package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.state.UiState
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrTabItem
import com.eshc.goonersapp.core.designsystem.component.GnrTopBar
import com.eshc.goonersapp.core.designsystem.component.MatchLeagueInfo
import com.eshc.goonersapp.core.designsystem.iconpack.IcTalk
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
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
                content = {
                    MatchDetailTopBar(
                        match = matchData.match
                    )
                }
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
                MatchInfoBoard(
                    match
                )
            }


            item {
                if(match.isFinished){
                    when (matchDetail) {
                        is UiState.Success -> {
                            MatchScoreBoard(
                                match = match,
                                matchDetailList = matchDetail.data
                            )
                        }

                        is UiState.Loading -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }

                        }

                        else -> {
                            //TODOx
                        }
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
                            match = match,
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
                color = if(history.teamId == 19) ColorFF10358A else ColorFF777777,
                style = GnrTypography.descriptionMedium
            )
        }
    }
}


enum class DetailTab {
    SUMMARY, COMMENT
}
