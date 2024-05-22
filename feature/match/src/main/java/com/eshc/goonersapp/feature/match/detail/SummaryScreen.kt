package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.Color88FFFFFF
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF889AC4
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE6EDFC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.match.component.formation.FootballFieldBox
import com.eshc.goonersapp.feature.match.component.formation.LineUpPlayerCard

@Composable
fun SummaryScreen(
    startingPlayers: List<List<Player>> = emptyList(),
    playerToWatchFor : Player = Player(0)
) {
    Column(
        modifier = Modifier
            .padding(start = 14.dp,end = 14.dp ,top = 22.dp, bottom =  80.dp)
    ) {

        Text(
            text = "Line-Ups",
            modifier = Modifier.padding(bottom = 16.dp),
            style = GnrTypography.subtitleMedium,
            color = ColorFF181818
        )

        LineUpBox(
            startingPlayers = startingPlayers
        )

        Text(
            text = "Player To Watch For",
            modifier = Modifier.padding(top = 70.dp, bottom = 16.dp),
            style = GnrTypography.subtitleMedium,
            color = ColorFF181818
        )
        PlayerToWatchForBox(
            player = playerToWatchFor,
            games = 0,
            goals = 0,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Composable
fun LineUpBox(
    startingPlayers : List<List<Player>>
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
            startingPlayers = startingPlayers
        )
    }
}


@Composable
fun PlayerToWatchForBox(
    player: Player,
    games : Int,
    goals : Int,
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
                    text = "${player.backNumber}",
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
                        text = player.displayName,
                        style = GnrTypography.body1Medium,
                        color = ColorFF10358A
                    )
                    Text(
                        text = player.position,
                        style = GnrTypography.descriptionRegular,
                        color = ColorFF10358A
                    )
                }
            }
            PlayerStatToWatchForRow(
                title = "Games",
                stat = "$games",
                modifier = Modifier.padding(bottom = 3.dp)
            )
            PlayerStatToWatchForRow(
                title = "Goals",
                stat = "$goals",
                modifier = Modifier
            )
        }
        
        AsyncImage(
            modifier = Modifier.fillMaxWidth(0.35f),
            model = "",
            contentDescription = ""
        )
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
            modifier = Modifier.wrapContentHeight().weight(0.45f),
            text = title,
            style = GnrTypography.body1Medium,
            color = ColorFF181818
        )
        Text(
            modifier = Modifier.wrapContentHeight().weight(0.1f),
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
    startingPlayers : List<List<Player>>
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        startingPlayers.forEach { players ->
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

@Preview
@Composable
fun PreviewSummaryScreen(){
    SummaryScreen()
}