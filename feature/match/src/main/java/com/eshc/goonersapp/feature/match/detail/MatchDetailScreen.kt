package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.ImageCard
import com.eshc.goonersapp.core.designsystem.component.GnrTabItem
import com.eshc.goonersapp.core.designsystem.iconpack.IcTalk
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.match.MatchData
import com.eshc.goonersapp.feature.match.model.MatchUiModel

@Composable
fun MatchDetailRoute(
    viewModel: MatchDetailViewModel = hiltViewModel(),
    onClickChat: (MatchUiModel) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    val matchData by viewModel.matchDetail.collectAsStateWithLifecycle()
    MatchDetailScreen(
        matchData = matchData,
        onClickChat = onClickChat
    )
}

@Composable
fun MatchDetailScreen(
    matchData: MatchData,
    onClickChat: (MatchUiModel) -> Unit
) {
    var selectedTab by remember { mutableStateOf(DetailTab.SUMMARY) }
    val match = matchData.match
    val matchDetail = matchData.matchDetail
    Box(
        modifier = Modifier
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
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(1f)
                    ) {
                        Text(
                            text = DateUtil.getYearAndMonthAndDateAndDayAndTimeString(match.matchDate),
                            style = GnrTypography.body1SemiBold,
                            color = ColorFF10358A,
                        )
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = match.stadiumName,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                        )
                    }
                    ImageCard(backgroundColor = Color(0xFF151D2D)) {
                        AsyncImage(
                            model = "https://www.arsenal.com/sites/default/files/styles/small/public/logos/comp_8.png?auto=webp&itok=EBszNKBn",
                            contentDescription = null
                        )
                    }

                }


            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 12.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    AsyncImage(
                        modifier = Modifier.width(64.dp),
                        model = match.homeTeamImageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = if (match.isFinished) "${match.homeScore} : ${match.awayScore}" else "  vs  ",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                    )
                    AsyncImage(
                        modifier = Modifier.width(64.dp),
                        model = match.awayTeamImageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                }

                Divider(
                    modifier = Modifier
                        .padding(top = 6.dp)
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

                    }

                    DetailTab.COMMENT -> {

                    }
                }


            }
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(18.dp),
            onClick = {
                // onClickChat(match)
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

enum class DetailTab {
    SUMMARY, COMMENT
}