package com.eshc.goonersapp.feature.team.club

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.component.TopBar
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.feature.team.state.ClubDetailUiState

@Composable
fun ClubDetailRoute(
    clubDetailViewModel: ClubDetailViewModel = hiltViewModel(),
    onShowSnackbar : (String) -> Unit
) {
    val clubDetailUiState by clubDetailViewModel.clubDetail.collectAsStateWithLifecycle()

    LaunchedEffect(clubDetailUiState){
        if(clubDetailUiState is ClubDetailUiState.Error){
            onShowSnackbar("Can't load Data")
        }
    }

    ClubDetailScreen(
        clubDetailUiState
    )
}

@Composable
fun ClubDetailScreen(
    clubDetailUiState: ClubDetailUiState
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            title = "CLUB"
        )
        when(clubDetailUiState){
            is ClubDetailUiState.Success -> {
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
                                model = clubDetailUiState.teamDetail.team.imageUrl,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(1f)
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
                            text = clubDetailUiState.teamDetail.team.clubName,
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
                            text = DateUtil.getYearAndMonthAndDateString(clubDetailUiState.teamDetail.team.foundationDate),
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
                            text = clubDetailUiState.teamDetail.team.manager,
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
                            text = clubDetailUiState.teamDetail.team.captain,
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
                            text = clubDetailUiState.teamDetail.team.stadiumName,
                            textAlign = TextAlign.Center,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                            fontSize = 14.sp,
                            letterSpacing = 0.1.sp
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Recently Results",
                    textAlign = TextAlign.Center,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp,
                    letterSpacing = 0.1.sp
                )
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(clubDetailUiState.teamDetail.recentlyMatches){
                        RecentlyResultItem(match = it)
                    }
                }
            }
            is ClubDetailUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
            else -> {

            }
        }

    }
}

@Composable
fun RecentlyResultItem(
    match : Match
) {
    Column(
        modifier = Modifier
            .wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.size(64.dp),
            model = if (match.homeTeamName == "Arsenal") match.awayTeamImageUrl else match.homeTeamImageUrl,
            contentDescription = null
        )
        Text(
            text = "${match.homeScore}:${match.awayScore}",
            fontSize = 18.sp
        )
        Text(
            text = if (match.homeTeamName == "Arsenal") {
                if (match.homeScore > match.awayScore) "WIN"
                else if (match.homeScore < match.awayScore) "LOSS"
                else "DRAW"
            } else {
                if (match.awayScore > match.homeScore) "WIN"
                else if (match.awayScore < match.homeScore) "LOSS"
                else "DRAW"
            }, fontSize = 18.sp
        )
    }

}