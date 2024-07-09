package com.eshc.goonersapp.feature.match.component.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.component.MatchLeagueInfo
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun CalendarListLeagueHeader(
    competitionUrl: String,
    competitionName: String
) {
    Row(
        modifier = Modifier
            .background(ColorFFF5F5F5)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        MatchLeagueInfo(
            logoSize = 25.dp,
            logoPadding = 3.dp,
            competitionUrl = competitionUrl,
            competitionName = competitionName,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
    }
}

@Composable
fun CalendarStickyHeader(
    season: String,
    onClickToday: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorFFFFFFFF)
            .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = season,
            style = GnrTypography.subtitleSemiBold
        )
        TodayButton(
            onClick = onClickToday,
            modifier = Modifier.height(22.dp)
        )
    }
}


@Preview
@Composable
fun PreviewStickyHeader() {
    CalendarListLeagueHeader(competitionUrl = "", competitionName = "Premier league")
}