package com.eshc.goonersapp.feature.match.component.calendar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.theme.ColorFF000000
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.match.Match

@Composable
fun CalendarListItem(
    match: Match,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(
            horizontal = 20.dp,
            vertical = 10.dp
        ),
        verticalArrangement = Arrangement.Center
    ) {
        CalendarTeamRow(
            dateString = DateUtil.getMonthAndDateString(match.matchDate),
            dateStyle = GnrTypography.body2SemiBold,
            dateStringColor = ColorFF10358A,
            teamImgUrl = match.homeTeamImageUrl,
            teamName = match.homeTeamName,
            teamScore = "${match.homeScore}"
        )
        Spacer(modifier = Modifier.size(4.dp))
        CalendarTeamRow(
            dateString = DateUtil.getTimeString(match.matchDate),
            dateStyle = GnrTypography.body2Medium,
            dateStringColor = ColorFF000000,
            teamImgUrl = match.awayTeamImageUrl,
            teamName = match.awayTeamName,
            teamScore = "${match.awayScore}"
        )
    }
}

@Composable
fun CalendarTeamRow(
    dateString: String,
    dateStyle: TextStyle,
    dateStringColor: Color,
    teamImgUrl: String,
    teamName: String,
    teamScore: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = dateString,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(end = 40.dp)
                .width(40.dp),
            color = dateStringColor,
            style = dateStyle
        )
        CalendarTeamLogo(teamImgUrl = teamImgUrl)
        Text(
            text = teamName,
            modifier = Modifier
                .padding(horizontal = 7.dp)
                .weight(4f),
            style = GnrTypography.descriptionMedium
        )
        Text(
            text = teamScore,
            style = GnrTypography.body1SemiBold
        )
    }
}

@Composable
fun CalendarTeamLogo(
    teamImgUrl: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .wrapContentSize()
            .border(
                width = 0.5.dp,
                shape = CircleShape,
                color = ColorFFDCDCDC
            ),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = ColorFFF5F5F5),
        content = {
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(22.dp),
                content = { AsyncImage(model = teamImgUrl, contentDescription = "League Logo") }
            )
        }
    )
}