package com.eshc.goonersapp.feature.team

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.feature.team.ui.SquadPlayerCard

@Composable
fun TeamRoute(
    onPlayerClick: (String) -> Unit,
) {
    TeamScreen(onClick = onPlayerClick)
}

@Composable
fun TeamScreen(
    viewModel: TeamViewModel = hiltViewModel(),
    onClick: (String) -> Unit
) {

    val items by viewModel.items.collectAsState()
    val st = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(st)
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            val int = intArrayOf(0, 1)
            int.sorted().reduceIndexed { index, acc, i ->
                if (index % 2 == 1) i else 0
            }
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                text = "GOALKEEPERS",
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 24.sp,
                lineHeight = 24.sp,
                letterSpacing = -1.sp
            )

            Divider(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 12.dp)
                    .width(20.dp), thickness = 4.dp
            )
        }
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),

            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                items.filter { it.positionCategory == "Goalkeeper" }
            ) {
                SquadPlayerCard(
                    it, onClick
                )
            }
        }

        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                text = "DEFENDERS",
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 24.sp,
                lineHeight = 24.sp,
                letterSpacing = -1.sp
            )

            Divider(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 12.dp)
                    .width(20.dp), thickness = 4.dp
            )
        }


        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),

            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                items.filter { it.positionCategory == "Defender" }
            ) {
                SquadPlayerCard(
                    it, onClick
                )
            }
        }


        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                text = "MIDFIELDERS",
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 24.sp,
                lineHeight = 24.sp,
                letterSpacing = -1.sp
            )

            Divider(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 12.dp)
                    .width(20.dp), thickness = 4.dp
            )
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),

            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                items.filter { it.positionCategory == "Midfielder" }
            ) {
                SquadPlayerCard(
                    it, onClick
                )
            }
        }


        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                text = "FORWARDS",
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 24.sp,
                lineHeight = 24.sp,
                letterSpacing = -1.sp
            )

            Divider(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 12.dp)
                    .width(20.dp), thickness = 4.dp
            )
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),

            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                items.filter { it.positionCategory == "Forward" }
            ) {
                SquadPlayerCard(
                    it, onClick
                )
            }
        }


        Spacer(modifier = Modifier.size(16.dp))
    }


}