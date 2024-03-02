package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.player.Player

@Composable
fun ProfileScreen(
    player : Player
) {
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
                    text = DateUtil.getYearAndMonthAndDateString(player.birthDate),
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
                    text = player.positionDetail,
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 16.sp,
                    letterSpacing = 0.1.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Weight",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    fontSize = 15.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = "${player.weight}kg",
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
                    text = player.nationality,
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 16.sp,
                    letterSpacing = 0.1.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Height",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    fontSize = 15.sp,
                    letterSpacing = 0.1.sp
                )
                Text(
                    text = "${player.height}cm",
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