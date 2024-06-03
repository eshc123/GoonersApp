package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrCard
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.iconpack.IcArrowRight
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.season.Rank

@Composable
fun DashboardCard(
    previewRankList: List<Rank>,
    modifier: Modifier = Modifier
) {
    GnrElevatedCard(
        colors = CardDefaults.cardColors(containerColor = ColorFFFFFFFF),
        radius = 10.dp,
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 7.dp)
        ) {
            LeagueDashboardTitle()
            Spacer(modifier = Modifier.size(7.dp))
            HorizontalDivider(
                modifier = modifier.fillMaxWidth(),
                color = ColorFFDCDCDC,
                thickness = 1.dp
            )
            Spacer(modifier = Modifier.size(5.dp))
            LeagueDashboardRow()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            previewRankList.forEach { rank ->
                LeagueDashboardItem(
                    rank = rank.position,
                    teamId = rank.teamId,
                    teamImgUrl = "",
                    teamShortName = rank.shortCode,
                    totalGames = rank.getTotalGames(),
                    wins = rank.wins,
                    draws = rank.draw,
                    losses = rank.loss,
                    goalDiff = rank.goalDifference,
                    points = rank.points
                )
            }
        }
    }
}

@Composable
fun LeagueDashboardTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "EPL",
            color = ColorFF181818,
            style = GnrTypography.body1Medium
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            content =  {
                Text(
                    text = "All",
                    color = ColorFF9E9E9E,
                    style = GnrTypography.descriptionMedium
                )
                Spacer(modifier = modifier.size(5.dp))
                Icon(
                    imageVector = IconPack.IcArrowRight,
                    contentDescription = "All",
                    tint = ColorFF9E9E9E
                )
            }
        )
    }
}

@Composable
fun LeagueDashboardRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(end = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Pos",
            textAlign = TextAlign.Center,
            modifier = modifier.weight(1f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = "Club",
            modifier = modifier.weight(3f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = "PL",
            modifier = modifier.weight(1f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = "W",
            modifier = modifier.weight(1f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = "D",
            modifier = modifier.weight(1f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = "L",
            modifier = modifier.weight(1f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = "GD",
            modifier = modifier.weight(1f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = "Pts",
            modifier = modifier.weight(1f),
            color = ColorFF9E9E9E,
            style = GnrTypography.descriptionMedium
        )
    }
}

@Composable
fun LeagueDashboardItem(
    rank: Int,
    teamId: Int,
    teamImgUrl: String,
    teamShortName: String,
    totalGames: Int,
    wins: Int,
    draws: Int,
    losses: Int,
    goalDiff: Int,
    points: Int,
    modifier: Modifier = Modifier
) {
    val cardContainerColor = if (teamId != 19) ColorFFF5F5F5 else ColorFF10358A
    val cardItemTextColor = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF

    GnrCard(
        shapeRadius = 5.dp,
        containerColor = cardContainerColor,
        modifier = modifier.fillMaxWidth().padding(vertical = 3.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 2.dp, bottom = 2.dp, end = 17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$rank",
                textAlign = TextAlign.Center,
                modifier = modifier.weight(1f),
                color = ColorFF9E9E9E,
                style = GnrTypography.body2Medium
            )
            LeagueDashBoardClubInfo(
                teamImgUrl = teamImgUrl,
                teamShortName = teamShortName,
                cardItemTextColor = cardItemTextColor,
                modifier = modifier.weight(3f)
            )
            Text(
                text = "$totalGames",
                modifier = modifier.weight(1f),
                color = cardItemTextColor,
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$wins", 
                modifier = modifier.weight(1f), 
                color = cardItemTextColor,
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$draws",
                modifier = modifier.weight(1f),
                color = cardItemTextColor,
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$losses",
                modifier = modifier.weight(1f),
                color = cardItemTextColor,
                style = GnrTypography.body2Regular
            )

            Text(
                text = "${if(goalDiff > 0)"+" else ""}${goalDiff}",
                modifier = modifier.weight(1f),
                color = cardItemTextColor,
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$points",
                modifier = modifier.weight(1f),
                color = cardItemTextColor,
                style = GnrTypography.body2SemiBold
            )
        }
    }
}

@Composable
fun LeagueDashBoardClubInfo(
    teamImgUrl: String,
    teamShortName: String,
    cardItemTextColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GnrCard(
            shapes = CircleShape,
            colors = CardDefaults.cardColors(containerColor = ColorFFFFFFFF),
            modifier = Modifier.size(22.dp)
        ) {
            AsyncImage(
                model = teamImgUrl,
                modifier = Modifier.padding(2.dp),
                contentDescription = "Club Logo Image"
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = teamShortName,
            color = cardItemTextColor,
            style = GnrTypography.body2Medium
        )
    }
}

