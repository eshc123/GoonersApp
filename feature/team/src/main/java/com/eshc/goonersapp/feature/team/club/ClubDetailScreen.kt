package com.eshc.goonersapp.feature.team.club

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.component.TopBar
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.Club

@Composable
fun ClubDetailRoute() {
    ClubDetailScreen(
        Club(
            clubId = 0,
            clubName = "Arsenal",
            officialName = "Arsenal Football Club",
            foundationDate = "1886-12-01T13:39:58.754Z",
            imageUrl = "https://www.arsenal.com/sites/default/files/styles/feed_crest_thumbnail/public/logos/arsenal-1.png?auto=webp&itok=7a6a0zug",
            teamNickname = "ARS",
            managerId = 28,
            manager = "Mikel Arteta",
            captainId = 8,
            captain = "Martin Ødegaard",
            stadiumName = "Emirates Stadium"
        )
    )
}

@Composable
fun ClubDetailScreen(
    club: Club
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            title = "Club"
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Card(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF151D2D)
                )
            ) {
                Box(
                    modifier = Modifier.padding(8.dp)
                ){
                    AsyncImage(
                        model = club.imageUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Column(
                modifier = Modifier.wrapContentHeight().weight(1f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Name",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = club.clubName,
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = "Foundation Date",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = DateUtil.getYearAndMonthAndDateString(club.foundationDate),
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = "Manager",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = club.manager,
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = "Captain",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = club.captain,
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = "Stadium",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = club.stadiumName,
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
            }
        }
    }
}