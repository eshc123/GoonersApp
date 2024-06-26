package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.component.MatchItemResultChip
import com.eshc.goonersapp.core.designsystem.ext.gnrElevatedCardBorder
import com.eshc.goonersapp.core.designsystem.iconpack.IcBall
import com.eshc.goonersapp.core.designsystem.iconpack.IcTrophy
import com.eshc.goonersapp.core.designsystem.theme.ColorFF000000
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF4C68A7
import com.eshc.goonersapp.core.designsystem.theme.ColorFFA5DBFF
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE6EDFC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF46B6C
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF69D4A
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.common.MatchResult
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.player.PlayerMatchStat


@Composable
fun LazyItemScope.MatchItem(
    playerMatchStat : PlayerMatchStat,
    modifier: Modifier = Modifier
) {
    GnrElevatedCard(
        modifier = modifier
            .gnrElevatedCardBorder(7.dp),
        radius = 7.dp,
        colors = CardDefaults.elevatedCardColors(
            containerColor = ColorFFFFFFFF
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.width(42.dp),
                    text = playerMatchStat.formattedDate,
                    style = GnrTypography.descriptionMedium,
                    color = ColorFF4C68A7,
                    textAlign = TextAlign.Start
                )
                MatchItemVersusTeamInfo(
                    match = playerMatchStat.match,
                    modifier = Modifier.padding(end = 6.dp)
                )
                MatchItemLeagueInfo(
                    match = playerMatchStat.match
                )
                MatchItemGoalInfo(
                    goals = playerMatchStat.goals
                )
            }
            Column(
                modifier = Modifier
                    .width(70.dp)
                    .fillMaxHeight()
                    .background(ColorFF10358A),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = playerMatchStat.match.matchScore,
                    style = GnrTypography.heading2SemiBold,
                    color = ColorFFFFFFFF
                )
                MatchItemResultChip(
                    playerMatchStat.match.getMatchResult(19).name.uppercase(),
                    color = when(playerMatchStat.match.getMatchResult(19)){
                        MatchResult.Win -> ColorFFA5DBFF
                        MatchResult.Draw -> ColorFFF69D4A
                        MatchResult.Loss -> ColorFFF46B6C
                    },
                    modifier = Modifier.width(50.dp)
                        .height(15.dp),
                )
            }
        }
    }
}

@Composable
fun RowScope.MatchItemVersusTeamInfo(
    match: Match,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(end = 6.dp),
            text = "VS",
            style = GnrTypography.descriptionMedium,
            color = ColorFF4C68A7
        )
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = match.getOpponentTeamImage(19),
                modifier = Modifier.size(18.dp),
                contentDescription = "Club Logo Image"
            )
            Text(
                text = match.getOpponentTeamNickname(19),
                style = GnrTypography.descriptionMedium,
                color = ColorFF181818
            )
        }
    }
}

@Composable
fun MatchItemLeagueInfo(
    match: Match,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(15.dp),
            imageVector = IconPack.IcTrophy,
            contentDescription = "league",
            tint = ColorFF10358A
        )
        Text(
            modifier = Modifier.padding(start = 7.dp),
            text = "PL",
            style = GnrTypography.body2Medium,
            color = ColorFF10358A
        )
    }

}

@Composable
fun MatchItemGoalInfo(
    goals: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(48.dp)
            .height(27.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorFFE6EDFC,
            contentColor = ColorFF10358A
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.CenterHorizontally)
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = IconPack.IcBall,
                contentDescription = "goal"
            )
            Text(
                text = "$goals",
                style = GnrTypography.body2Medium
            )
        }
    }
}


