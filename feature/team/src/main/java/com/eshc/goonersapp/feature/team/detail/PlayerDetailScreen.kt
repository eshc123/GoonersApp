package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.TabItem
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.team.state.PlayerDetailUiState


@Composable
fun PlayerDetailScreen(
    viewModel: PlayerDetailViewModel = hiltViewModel(),
    onShowSnackbar : (String) -> Unit
) {

    var selectedTab by remember { mutableStateOf(DetailTab.PROFILE) }
    val playerDetailUiState by viewModel.playerDetailUiState.collectAsStateWithLifecycle()

    when(playerDetailUiState){
        is PlayerDetailUiState.Success -> {
            (playerDetailUiState as PlayerDetailUiState.Success).playerDetail.let { player: Player ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            model = player.imageUrl,
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                        )

                        Text(
                            modifier = Modifier.padding(start = 12.dp, top = 16.dp),
                            textAlign = TextAlign.Start,
                            text = "${player.backNumber}. ${player.name}",
                            color = Color.Black,
                            style = MaterialTheme.typography.headlineMedium,
                        )

                        Text(
                            modifier = Modifier.padding(start = 12.dp, bottom = 16.dp),
                            textAlign = TextAlign.Start,
                            text = player.positionDetail,
                            color = Color.LightGray,
                            style = MaterialTheme.typography.labelLarge,
                        )

                        Divider(
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .fillMaxWidth(), thickness = 8.dp, color = Color(0xFFE4E4E4)
                        )
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            DetailTab.entries.forEach {
                                TabItem(
                                    modifier = Modifier.weight(1f),
                                    tabTitle = it.name,
                                    isSelected = selectedTab == it,
                                    onSelect = {
                                        selectedTab = it
                                    }
                                )
                            }
                        }
                    }

                    item {
                        when(selectedTab){
                            DetailTab.PROFILE -> {
                                ProfileScreen(player = player)
                            }
                            DetailTab.STATS -> {
                                StatScreen()
                            }
                        }


                    }
                }
            }

        }
        is PlayerDetailUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        else -> {
            // TODO Error
        }
    }


}


enum class DetailTab {
    PROFILE, STATS
}