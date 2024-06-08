package com.eshc.goonersapp.feature.team.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.component.GnrTabItem
import com.eshc.goonersapp.core.designsystem.ext.gnrElevatedCardBorder
import com.eshc.goonersapp.core.designsystem.iconpack.IcIosArrowBack
import com.eshc.goonersapp.core.designsystem.iconpack.IcNotification
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF720509
import com.eshc.goonersapp.core.designsystem.theme.ColorFFC10006
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.team.state.PlayerDetailUiState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerDetailRootScreen(
    onBackIconClick: () -> Unit,
    onShowSnackbar: (String) -> Unit,
    viewModel : PlayerDetailViewModel = hiltViewModel()
) {
    val playerDetailUiState by viewModel.playerDetailUiState.collectAsStateWithLifecycle()
    var selectedTab by remember { mutableStateOf(DetailTab.PROFILE) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                navigationIcon = {
                    Icon(
                        imageVector = IconPack.IcIosArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(24.dp)
                            .clickable(onClick = onBackIconClick),
                        tint = ColorFFFFFFFF
                    )
                },
                actions = {
                    Icon(
                        imageVector = IconPack.IcNotification,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(24.dp)
                            .clickable { /* TODO("Not yet implemented") */ },
                        tint = ColorFFFFFFFF
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { _ ->
        PlayerDetailScreen(
            playerDetailUiState = playerDetailUiState,
            selectedTab = selectedTab,
            onShowSnackbar =  onShowSnackbar,
            onUpdateTab = { tab -> selectedTab = tab },
            modifier = Modifier
        )
    }
}


@Composable
fun PlayerDetailScreen(
    playerDetailUiState : PlayerDetailUiState,
    selectedTab : DetailTab,
    onShowSnackbar: (String) -> Unit,
    onUpdateTab : (DetailTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = ColorFFFFFFFF
    ) {
        when (playerDetailUiState) {
            is PlayerDetailUiState.Success -> {
                playerDetailUiState.playerDetail.let { player: Player ->
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
                                    content = "${player.age}"
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

                            HorizontalDivider(
                                modifier = Modifier.padding(top = 14.dp),
                                thickness = 7.dp,
                                color = ColorFFF5F5F5
                            )
                        }

                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                DetailTab.entries.forEach {
                                    GnrTabItem(
                                        modifier = Modifier.weight(1f),
                                        tabTitle = it.name,
                                        isSelected = selectedTab == it,
                                        onSelect = {
                                            onUpdateTab(it)
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
                        ColorFFC10006,
                        ColorFF720509
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
                    model = player.nationalityImageUrl,
                    contentDescription = "Flag",
                    contentScale = ContentScale.Crop
                )
                PlayerDetailBackNumberChip(
                    backNumber = player.backNumber,
                    backgroundColor = ColorFFC10006
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
            .weight(1f)
            .gnrElevatedCardBorder(15.dp),
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