package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF889AC4
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE6EDFC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.match.component.formation.FootballFieldBox
import com.eshc.goonersapp.feature.match.component.formation.LineUpPlayerCard

@Composable
fun SummaryScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
    ) {

        Text(
            text = "Line-Ups",
            modifier = Modifier.padding(top = 30.dp, bottom = 16.dp),
            style = GnrTypography.subtitleMedium,
            color = ColorFF181818
        )

        Box(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Max)
        ) {
            FootballFieldBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.9f, true),
                rotateDegree = 180f
            )
            PlayerLineupBox()
        }

        Text(
            text = "Player To Watch For",
            modifier = Modifier.padding(top = 30.dp, bottom = 16.dp),
            style = GnrTypography.subtitleMedium,
            color = ColorFF181818
        )
        PlayerToWatchForBox(
            modifier = Modifier.fillMaxWidth()
        )
    }

}


@Composable
fun PlayerToWatchForBox(
    modifier: Modifier = Modifier
){
    BoxWithConstraints(
        modifier = modifier.background(
            color = ColorFFE6EDFC,
            shape = RoundedCornerShape(10.dp)
        )
    ){
        val boxWidth = maxWidth.value
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 8.dp)
                    .offset(x = (boxWidth * 0.3f).dp)
            ){
                Text(
                    text = "8",
                    style = GnrTypography.heading2SemiBold,
                    color = ColorFF889AC4
                )
                Column(
                    modifier = Modifier.padding(start = 4.dp)
                ) {
                    Text(
                        text = "Martin Ødegaard",
                        style = GnrTypography.body1Medium,
                        color = ColorFF10358A
                    )
                    Text(
                        text = "Midfielder",
                        style = GnrTypography.descriptionRegular,
                        color = ColorFF10358A
                    )
                }
            }

        }
    }
}

@Composable
fun PlayerLineupBox(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Aaron Ramsdale",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ){

            LineUpPlayerCard(
                player = Player(
                    id = 1,
                    name = "Emile Smith-Rowe",
                    backNumber = 17,
                    imageUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p85955.png"
                )
            )

        }
    }
}

@Preview
@Composable
fun PreviewPlayerToWatchForBox(){
    PlayerToWatchForBox()
}