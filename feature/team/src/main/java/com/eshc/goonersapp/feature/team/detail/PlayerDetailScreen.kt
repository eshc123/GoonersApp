package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.component.TabItem
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.team.state.PlayerDetailUiState


@Composable
fun PlayerDetailScreen(
    viewModel: PlayerDetailViewModel = hiltViewModel(),
    onShowSnackbar: (String) -> Unit
) {

    var selectedTab by remember { mutableStateOf(DetailTab.PROFILE) }
    val playerDetailUiState by viewModel.playerDetailUiState.collectAsStateWithLifecycle()

    Surface(
        color = ColorFFFFFFFF
    ) {
        when (playerDetailUiState) {
            is PlayerDetailUiState.Success -> {
                (playerDetailUiState as PlayerDetailUiState.Success).playerDetail.let { player: Player ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item {
                            PlayerDetailImage(
                                player = player,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.3f)
                            )
                        }

                        item {
                            Row(
                                modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp),
                                horizontalArrangement = Arrangement.spacedBy(20.dp)
                            ) {
                                PlayerDetailInfo(
                                    title = "Age",
                                    content = "22"
                                )
                                PlayerDetailInfo(
                                    title = "Games",
                                    content = "14"
                                )
                                PlayerDetailInfo(
                                    title = "Goals",
                                    content = "10"
                                )
                            }
                        }

                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                                horizontalArrangement = Arrangement.spacedBy(24.dp)
                            ) {
                                DetailTab.entries.forEach {
                                    TabItem(
                                        modifier = Modifier.width(IntrinsicSize.Max),
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
                            when (selectedTab) {
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
                ) {
                    CircularProgressIndicator()
                }
            }

            else -> {
                // TODO Error
            }
        }
    }

}

@Composable
fun PlayerDetailImage(
    player: Player,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
            )
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFC10006),
                        Color(0xFF720509)
                    )
                )
            ),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight(0.857f)
                .aspectRatio(1f)
                .align(Alignment.BottomEnd),
            model = player.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterStart)
                .padding(25.dp),
            verticalArrangement = Arrangement.spacedBy(11.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape),
                    model = "https://cdn.sportmonks.com/images/countries/png/short/gb.png", //
                    contentDescription = "Flag",
                    contentScale = ContentScale.Crop
                )
                PlayerDetailBackNumberChip(
                    backNumber = player.backNumber,
                    backgroundColor = Color(0xFFC10006),
                )
            }
            Text(
                text = player.displayName,
                lineHeight = 30.sp,
                style = GnrTypography.heading1Bold.copy(fontSize = 28.sp),
                color = ColorFFFFFFFF
            )
            Text(
                text = player.position,
                style = GnrTypography.body1Medium,
                color = ColorFFFFFFFF
            )
        }

    }
}

@Composable
fun PlayerDetailBackNumberChip(
    backNumber: Int,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(35.dp)
            .clip(CircleShape)
            .background(color = backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$backNumber",
            style = GnrTypography.subtitleSemiBold,
            color = ColorFFFFFFFF
        )
    }
}

@Composable
fun RowScope.PlayerDetailInfo(
    title: String,
    content: String
) {
    GnrElevatedCard(
        modifier = Modifier
            .height(110.dp)
            .weight(1f),
        radius = 15.dp,
        colors = CardDefaults.elevatedCardColors(
            containerColor = ColorFFFFFFFF
        )
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            Text(
                modifier = Modifier.align(Alignment.TopStart),
                text = title,
                style = GnrTypography.body1Regular,
                color = ColorFF181818
            )
            Text(
                modifier = Modifier.align(Alignment.BottomEnd),
                text = content,
                style = GnrTypography.heading1Bold,
                color = ColorFF10358A
            )
        }
    }
}

enum class DetailTab {
    PROFILE, STATS
}