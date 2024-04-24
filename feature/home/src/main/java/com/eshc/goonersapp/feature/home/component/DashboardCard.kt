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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GNRCard
import com.eshc.goonersapp.core.designsystem.component.GNRElevatedCard
import com.eshc.goonersapp.core.designsystem.iconpack.IcArrowRight
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun DashboardCard(modifier: Modifier = Modifier) {
    GNRElevatedCard(
        colors = CardDefaults.cardColors(containerColor = ColorFFFFFFFF),
        radius = 10.dp,
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 5.dp),
            content =  {
                LeagueDashboardTitle()
                Spacer(modifier = Modifier.size(5.dp))
                HorizontalDivider(
                    modifier = modifier.fillMaxWidth(),
                    color = ColorFFDCDCDC,
                    thickness = 1.dp
                )
                Spacer(modifier = Modifier.size(5.dp))
                LeagueDashboardRow()
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 12.dp)
        ){
            LeagueDashboardItem(
                rank = 1,
                teamId = 20,
                teamImgUrl = "",
                teamShortName = "MCI",
                totalGames = 31,
                wins = 22,
                draws = 5,
                losses = 4,
                goalDiff = 51,
                points = 71
            )
            LeagueDashboardItem(
                rank = 2,
                teamId = 19,
                teamImgUrl = "",
                teamShortName = "ARS",
                totalGames = 31,
                wins = 21,
                draws = 8,
                losses = 2,
                goalDiff = 42,
                points = 71
            )
            LeagueDashboardItem(
                rank = 3,
                teamId = 100,
                teamImgUrl = "",
                teamShortName = "CHE",
                totalGames = 30,
                wins = 18,
                draws = 7,
                losses = 3,
                goalDiff = 40,
                points = 70
            )
            LeagueDashboardItem(
                rank = 4,
                teamId = 201,
                teamImgUrl = "",
                teamShortName = "TOT",
                totalGames = 32,
                wins = 18,
                draws = 6,
                losses = 7,
                goalDiff = 20,
                points = 60
            )
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
        modifier = modifier.fillMaxWidth().padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Pos",
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
    GNRCard(
        shapeRadius = 5.dp,
        containerColor = if (teamId != 19) ColorFFF5F5F5 else ColorFF10358A,
        modifier = modifier.fillMaxWidth().padding(vertical = 3.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$rank",
                modifier = modifier.weight(1f),
                color = ColorFF9E9E9E,
                style = GnrTypography.body2Medium
            )
            LeagueDashBoardClubInfo(
                teamId = teamId,
                teamImgUrl = teamImgUrl,
                teamShortName = teamShortName,
                modifier = modifier.weight(3f)
            )
            Text(
                text = "$totalGames",
                modifier = modifier.weight(1f),
                color = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF,
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$wins", 
                modifier = modifier.weight(1f), 
                color = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF, 
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$draws",
                modifier = modifier.weight(1f),
                color = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF,
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$losses",
                modifier = modifier.weight(1f),
                color = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF,
                style = GnrTypography.body2Regular
            )

            Text(
                text = "${if(goalDiff > 0)"+" else ""}${goalDiff}",
                modifier = modifier.weight(1f),
                color = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF,
                style = GnrTypography.body2Regular
            )
            Text(
                text = "$points",
                modifier = modifier.weight(1f),
                color = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF,
                style = GnrTypography.body2SemiBold
            )
        }
    }
}

@Composable
fun LeagueDashBoardClubInfo(
    teamId: Int,
    teamImgUrl: String,
    teamShortName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GNRCard(
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
            color = if (teamId != 19) ColorFF181818 else ColorFFFFFFFF,
            style = GnrTypography.body2Medium
        )
    }
}