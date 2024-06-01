package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.core.designsystem.theme.ColorFF889AC4
import com.eshc.goonersapp.core.designsystem.theme.ColorFFC3CDE2
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.match.model.MatchUiModel

@Composable
fun LazyItemScope.MatchInfoBoard(
    match: MatchUiModel
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TeamLogoImageBox(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            teamLogoImageUrl = match.homeTeamImageUrl,
            teamName = match.homeTeamName
        )
        if (match.isFinished) {
            MatchResultBoard(
                match
            )
        } else {
            MatchFixtureBoard(
                match
            )
        }

        TeamLogoImageBox(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            teamLogoImageUrl = match.awayTeamImageUrl,
            teamName = match.awayTeamName
        )
    }
}


@Composable
fun RowScope.MatchFixtureBoard(
    match: MatchUiModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier
                .height(78.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = DateUtil.getMonthAndDateAndDayString(match.matchDate),
                style = GnrTypography.heading2SemiBold,
                color = ColorFF889AC4
            )
            Text(
                text = DateUtil.getTimeString(match.matchDate),
                style = GnrTypography.heading2SemiBold,
                color = ColorFF10358A
            )

        }
        Text(
            modifier = Modifier.padding(top = 3.dp),
            text = match.stadiumName,
            style = GnrTypography.body2Regular,
            color = ColorFF777777
        )
    }
}

@Composable
fun RowScope.MatchResultBoard(
    match: MatchUiModel,
    modifier: Modifier = Modifier
) {
    val annotatedScore = if (match.isFinished) buildAnnotatedString {
        withStyle(style = SpanStyle(ColorFF10358A)) { append("${match.homeScore} ") }
        withStyle(style = SpanStyle(ColorFFC3CDE2)) { append(":") }
        withStyle(style = SpanStyle(ColorFF10358A)) { append(" ${match.awayScore}") }
    } else buildAnnotatedString {
        withStyle(style = SpanStyle(ColorFF10358A)) { append("  vs  ") }
    }
    Column(
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier
                .height(78.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp,Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = annotatedScore,
                style = GnrTypography.heading1Bold.copy(
                    fontSize = 28.sp
                ),
            )
            Text(
                text = DateUtil.getYearAndMonthAndDateAndDayAndTimeString(match.matchDate),
                style = GnrTypography.body1Medium,
                color = ColorFF777777
            )

        }
        Text(
            modifier = Modifier.padding(top = 3.dp),
            text = match.stadiumName,
            style = GnrTypography.body2Regular,
            color = ColorFF777777
        )
    }


}


@Composable
fun TeamLogoImageBox(
    teamName: String,
    teamLogoImageUrl: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(78.dp)
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
                    .size(64.dp)
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

        Text(
            modifier = Modifier.padding(top = 3.dp),
            text = teamName,
            textAlign = TextAlign.Center,
            color = ColorFF181818,
            style = GnrTypography.body2SemiBold
        )
    }

}
