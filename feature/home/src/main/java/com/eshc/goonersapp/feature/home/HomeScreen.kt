package com.eshc.goonersapp.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.eshc.goonersapp.feature.home.component.DashboardCard
import com.eshc.goonersapp.feature.home.component.RecentlyMatchCard
import com.eshc.goonersapp.feature.home.component.UpcomingMatchTicketCard


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeRoute() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                text = "HOME",
                //fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 30.sp,
            )

            Spacer(modifier = Modifier.height(12.dp))

        }

        item {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Team Dashboard",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.height(12.dp))
            DashboardCard()
        }



        item {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Upcoming Matches",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp),

                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                item {
                    UpcomingMatchTicketCard(
                        homeShortName = "WHU",
                        homeUrl = "https://www.arsenal.com/sites/default/files/styles/feed_crest_thumbnail/public/logos/westhamunited.png?auto=webp&itok=37U68OD4",
                        time = "2023.11.02 04:30",
                        location = "London Stadium",
                        competitionUrl = "https://www.arsenal.com/sites/default/files/styles/small/public/logos/Unknown-1.png?auto=webp&itok=vWaxFMmA"
                    )
                    UpcomingMatchTicketCard(
                        homeShortName = "NEW",
                        homeUrl = "https://www.arsenal.com/sites/default/files/styles/feed_crest_thumbnail/public/logos/newcastleunited_0.png?auto=webp&itok=fIdaH1e6",
                        time = "2023.11.05 02:30",
                        location = "St. James' Park",
                        competitionUrl = "https://www.arsenal.com/sites/default/files/styles/small/public/logos/comp_8.png?auto=webp&itok=EBszNKBn"
                    )
                }
            }
        }
        item {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Recently Result",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.height(12.dp))

            RecentlyMatchCard(
                homeShortName = "WHU",
                homeUrl = "https://www.arsenal.com/sites/default/files/styles/feed_crest_thumbnail/public/logos/westhamunited.png?auto=webp&itok=37U68OD4",
                time = "2023.11.02 04:30",
                location = "London Stadium",
                competitionUrl = "https://www.arsenal.com/sites/default/files/styles/small/public/logos/Unknown-1.png?auto=webp&itok=vWaxFMmA"
            )
        }



    }
}


