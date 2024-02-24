package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.ImageCard
import com.eshc.goonersapp.core.designsystem.shape.TicketShape
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun UpcomingMatchTicketCard(
    homeShortName: String ,
    homeUrl: String,
    awayShortName: String,
    awayUrl: String,
    time: String,
    location: String,
    competitionUrl: String
) {
    ElevatedCard(
        modifier = Modifier
            .width(260.dp)
            .height(180.dp),
        shape = TicketShape(8.dp, CornerSize(4.dp), weight = 2f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color(0xFF151D2D)),//0xFFDA0209)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    //.background(Color(1f, 0f, 0f, 0.9f))
                    .fillMaxWidth()
                    .weight(2f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = homeShortName,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 36.sp,
                    )
                    AsyncImage(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.CenterHorizontally),
                        model = homeUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),//.background(Color.Red),
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = awayShortName,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 36.sp,
                    )
                    AsyncImage(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.CenterHorizontally),
                        model = awayUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

            }


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = time,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 13.sp,
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
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
                fontSize = 13.sp,
            )

        }
    }
}


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
                        .padding(bottom = 4.dp, top = 12.dp, start= 12.dp, end = 12.dp),
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
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 24.sp,
                            )
                            Text(
                                text = score,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 24.sp,
                            )
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                text = awayShortName,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 24.sp,
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
                    ) {
//                        Text(
//                            modifier = Modifier.padding(horizontal = 4.dp),
//                            text = "7` Saka",
//                            fontWeight = FontWeight.Normal,
//                            color = Color.White,
//                            fontSize = 18.sp,
//                        )

                    }

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
                modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = time,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 13.sp,
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
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
                fontSize = 13.sp,
            )
        }
    }
}
