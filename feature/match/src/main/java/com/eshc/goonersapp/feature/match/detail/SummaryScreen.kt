package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.state.UiState
import com.eshc.goonersapp.core.designsystem.theme.Color88FFFFFF
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF889AC4
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE6EDFC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import com.eshc.goonersapp.core.domain.model.match.NotablePlayer
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.match.component.formation.FootballFieldBox
import com.eshc.goonersapp.feature.match.component.formation.LineUpPlayerCard

@Composable
fun SummaryScreen(
    lineupUiState: UiState<MatchLineup>,
    matchInformationState : UiState<MatchInformation>,
) {
    Column(
        modifier = Modifier
            .padding(start = 14.dp,end = 14.dp ,top = 22.dp, bottom =  80.dp)
    ) {
        when(lineupUiState){
            is UiState.Success -> {
                Text(
                    text = "Line-Ups",
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = GnrTypography.subtitleMedium,
                    color = ColorFF181818
                )

                LineUpBox(
                    matchLineup = lineupUiState.data
                )
            }
            is UiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            else -> {

            }
        }
        when(matchInformationState){
            is UiState.Success -> {
                matchInformationState.data.notablePlayer?.let {
                    Text(
                        text = "Player To Watch For",
                        modifier = Modifier.padding(top = 70.dp, bottom = 16.dp),
                        style = GnrTypography.subtitleMedium,
                        color = ColorFF181818
                    )
                    PlayerToWatchForBox(
                        player = it,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            is UiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            else -> {

            }
        }




    }

}

@Composable
fun LineUpBox(
    matchLineup: MatchLineup
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        FootballFieldBox(
            modifier = Modifier.fillMaxSize(),
            rotateDegree = 180f
        )
        PlayerLineUpBox(
            matchLineup = matchLineup
        )
    }
}


@Composable
fun PlayerToWatchForBox(
    player: NotablePlayer,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.background(
            color = ColorFFE6EDFC,
            shape = RoundedCornerShape(10.dp)
        )
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 8.dp, end = 12.dp)
            ){
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(0.45f)
                        .padding(end = 18.dp),
                    text = "",
                    style = GnrTypography.heading2SemiBold,
                    color = ColorFF889AC4,
                    textAlign = TextAlign.End
                )
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(0.55f)
                ) {
                    Text(
                        text = player.playerName,
                        style = GnrTypography.body1Medium,
                        color = ColorFF10358A
                    )
                    Text(
                        text = player.playerPosition,
                        style = GnrTypography.descriptionRegular,
                        color = ColorFF10358A
                    )
                }
            }
            PlayerStatToWatchForRow(
                title = "Games",
                stat = "${player.playerParticipationCount}",
                modifier = Modifier.padding(bottom = 3.dp)
            )
            PlayerStatToWatchForRow(
                title = "Goals",
                stat = "${player.playerGoalCount}",
                modifier = Modifier
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(0.4f),
            contentAlignment = Alignment.BottomCenter
        ){
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                model = player.playerImageUrl,
                contentDescription = "player"
            )
        }

    }
}

@Composable
fun PlayerStatToWatchForRow(
    title : String,
    stat : String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .background(color = Color88FFFFFF)
            .padding(top = 10.dp, bottom = 8.dp, end = 12.dp)
    ){
        Spacer(
            modifier = Modifier
                .wrapContentHeight()
                .weight(0.45f)
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(0.45f),
            text = title,
            style = GnrTypography.body1Medium,
            color = ColorFF181818
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(0.1f),
            text = stat,
            maxLines = 1,
            textAlign = TextAlign.Center,
            style = GnrTypography.body1Medium,
            color = ColorFF10358A
        )
    }
}

@Composable
fun PlayerLineUpBox(
    matchLineup: MatchLineup
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        matchLineup.getMyTeamLineup(19).groupStartingPlayersByPosition().forEach { players ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                players.forEach {  player ->
                    LineUpPlayerCard(
                        player = player
                    )
                }

            }
        }
    }
}