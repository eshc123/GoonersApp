package com.eshc.goonersapp.feature.team

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlayerDetailScreen(
    viewModel: PlayerDetailViewModel = hiltViewModel()
) {

    var selectedTab by remember { mutableStateOf(DetailTab.PROFILE) }
    val player by viewModel.playerDetail.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.FillWidth,
                model = player.imageUrl,
                contentDescription = null
            ) {
                it.diskCacheStrategy(
                    DiskCacheStrategy.ALL
                )
            }

            Text(
                modifier = Modifier.padding(start = 12.dp, top = 16.dp),
                textAlign = TextAlign.Start,
                text = "${player.backNumber}. ${player.name.replace("\n"," ")}",
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 26.sp,
                lineHeight = 26.sp
            )

            Text(
                modifier = Modifier.padding(start = 12.dp, bottom = 16.dp),
                textAlign = TextAlign.Start,
                text = player.position,
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                color = Color.LightGray,
                fontSize = 14.sp,
                lineHeight = 26.sp
            )

            Divider(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .fillMaxWidth(), thickness = 8.dp, color = Color(0xFFE4E4E4)
            )
        }

//        item {
//            Row(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                DetailTab.values().forEach {
//                    TabItem(
//                        modifier = Modifier.weight(1f),
//                        tabTitle = it.name,
//                        isSelected = selectedTab == it,
//                        onSelect = {
//                            selectedTab = it
//                        }
//                    )
//                }
//            }
//        }

        item {
            OutlinedCard(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                border = BorderStroke(width = 1.dp, color = Color(0xFFF1F1F1)),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.Transparent
                )

            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Date Of Birth",
                            textAlign = TextAlign.Center,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 15.sp,
                            letterSpacing = 0.1.sp
                        )
                        Text(
                            text = "May 14, 1998 (25)",
                            textAlign = TextAlign.Center,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                            fontSize = 16.sp,
                            letterSpacing = 0.1.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Position",
                            textAlign = TextAlign.Center,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 15.sp,
                            letterSpacing = 0.1.sp
                        )
                        Text(
                            text = player.position,
                            textAlign = TextAlign.Center,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                            fontSize = 16.sp,
                            letterSpacing = 0.1.sp
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Nationality",
                            textAlign = TextAlign.Center,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 15.sp,
                            letterSpacing = 0.1.sp
                        )
                        Text(
                            text = "England",
                            textAlign = TextAlign.Center,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                            fontSize = 16.sp,
                                    letterSpacing = 0.1.sp
                        )
                    }
                }


            }

        }
    }
}

@Composable
fun TabItem(
    modifier: Modifier = Modifier,
    tabTitle: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable {
                onSelect()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = tabTitle,
            fontFamily = pretendard,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) Color.Black else Color.LightGray,
            fontSize = 14.sp
        )
        if (isSelected)
            Divider(
                modifier = Modifier,
                color = Color.Black,
                thickness = 2.dp
            )
    }
}

enum class DetailTab {
    PROFILE, STATS, etc
}