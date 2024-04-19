package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.GNRElevatedCard
import com.eshc.goonersapp.core.designsystem.component.ImageCard
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF4C68A7
import com.eshc.goonersapp.core.designsystem.theme.ColorFFC3CDE2
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF7F9FF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun RecentlyMatchCard(
    homeShortName: String ,
    homeUrl: String ,
    awayShortName: String,
    awayUrl: String,
    time: String,
    location: String,
    competitionUrl: String,
    score : String
) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFF151D2D)),//0xFFDA0209)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    //.background(Color(1f, 0f, 0f, 0.9f))
                    .fillMaxWidth()
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 4.dp, top = 12.dp, start = 12.dp, end = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterVertically),
                        contentScale = ContentScale.Crop,
                        model = homeUrl,
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                text = homeShortName,
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                            Text(
                                text = score,
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                text = awayShortName,
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                        }

                    }
                    AsyncImage(
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterVertically),
                        contentScale = ContentScale.Crop,
                        model = awayUrl,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier
                    .width(0.dp)
                    .height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier
                        .height(0.dp)
                        .width(8.dp))

                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(1f)
                            .padding(start = 28.dp, bottom = 12.dp, end = 12.dp)
                    ) {  }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = time,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.DarkGray,
                )
                ImageCard(backgroundColor = Color(0xFF151D2D)) {
                    AsyncImage(
                        model = competitionUrl,
                        contentDescription = null,
                        modifier = Modifier.width(40.dp)
                    )
                }
            }
            Text(
                text = location,
                style = MaterialTheme.typography.labelLarge,
                color = Color.DarkGray,
            )
        }
    }
}

@Composable
fun RecentlyMatchCard(
    modifier: Modifier = Modifier
) {
    GNRElevatedCard(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .border(
                width = 1.dp,
                color = ColorFFF5F5F5,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        radius = 10.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

@Composable
fun UpcomingMatchCard(
    modifier: Modifier = Modifier,
    homeUrl: String,
    homeShortName: String,
    awayUrl: String,
    awayShortName: String,
    time: String,
    location: String,
    competitionUrl: String,
    competitionName: String
) {
    GNRElevatedCard(
        modifier = modifier
            .width(263.dp)
            .height(131.dp)
            .border(
                width = 1.dp,
                color = ColorFFF5F5F5,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        radius = 10.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UpcomingMatchLeagueInfo(
                modifier = modifier.fillMaxWidth(),
                competitionUrl = competitionUrl,
                competitionName = competitionName
            )
            UpcomingMatchInfo(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                homeUrl = homeUrl,
                homeShortName = homeShortName,
                awayUrl = awayUrl,
                awayShortName = awayShortName
            )
            UpcomingMatchDateInfo(
                modifier = modifier.fillMaxWidth(),
                time = time,
                location = location
            )
        }
    }
}

@Composable
fun UpcomingMatchLeagueInfo(
    modifier: Modifier = Modifier,
    competitionUrl: String,
    competitionName: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .border(
                    width = 0.5.dp,
                    shape = CircleShape,
                    color = ColorFFDCDCDC
                ),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
            content = {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(22.dp),
                    content = { AsyncImage(model = competitionUrl, contentDescription = "League Logo") }
                )
            }
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = competitionName,
            color = ColorFF181818,
            style = GnrTypography.descriptionSemiBold
        )
    }
}

@Composable
fun UpcomingMatchInfo(
    modifier: Modifier = Modifier,
    homeUrl: String,
    homeShortName: String,
    awayUrl: String,
    awayShortName: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            HomeTeamInfo(homeUrl = homeUrl, homeShortName = homeShortName)
            Text(text = "VS", color = ColorFF10358A, style = GnrTypography.subtitleMedium)
            AwayTeamInfo(awayUrl = awayUrl, awayShortName = awayShortName)
        }
    )
}

@Composable
fun HomeTeamInfo(
    modifier: Modifier = Modifier,
    homeUrl: String,
    homeShortName: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        content = {
            AsyncImage(
                model = homeUrl,
                modifier = modifier.size(30.dp),
                contentDescription = "Home Team Logo"
            )
            Spacer(modifier = modifier.size(10.dp))
            Text(
                text = homeShortName,
                style = GnrTypography.subtitleMedium
            )
        }
    )
}

@Composable
fun AwayTeamInfo(
    modifier: Modifier = Modifier,
    awayUrl: String,
    awayShortName: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        content = {
            Text(
                text = awayShortName,
                style = GnrTypography.subtitleMedium
            )
            Spacer(modifier = modifier.size(10.dp))
            AsyncImage(
                model = awayUrl,
                modifier = modifier.size(30.dp),
                contentDescription = "Away Team Logo"
            )
        }
    )
}

@Composable
fun UpcomingMatchDateInfo(
    modifier: Modifier = Modifier,
    time: String,
    location: String
) {
    Card(
        modifier = modifier.wrapContentHeight(),
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorFFF7F9FF,
            contentColor = ColorFF4C68A7
        ),
        border = BorderStroke(
            width = 0.5.dp,
            color = ColorFFC3CDE2
        )
    ) {
        Row(
            modifier = modifier.padding(vertical = 3.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            content = {
                Text(
                    text = time,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = GnrTypography.body2Medium
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = location,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = GnrTypography.body2Medium
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUpcomingMatchCard() {
    UpcomingMatchCard(
        homeUrl = "",
        homeShortName = "ARS",
        awayUrl = "",
        awayShortName = "MIC",
        location = "Bramall Lane",
        time = "2024.03.31 17:30",
        competitionUrl = "",
        competitionName = "Premier League"
    )
}