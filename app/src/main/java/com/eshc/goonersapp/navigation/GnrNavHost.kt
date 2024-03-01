package com.eshc.goonersapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.eshc.goonersapp.feature.chat.navigation.chatRoomScreen
import com.eshc.goonersapp.feature.chat.navigation.navigateToChatRoom
import com.eshc.goonersapp.feature.home.navigation.homeNavigationRoute
import com.eshc.goonersapp.feature.home.navigation.homeScreen
import com.eshc.goonersapp.feature.match.model.toUiModel
import com.eshc.goonersapp.feature.match.navigation.matchDetailScreen
import com.eshc.goonersapp.feature.match.navigation.matchScreen
import com.eshc.goonersapp.feature.team.navigation.clubDetailScreen
import com.eshc.goonersapp.feature.match.navigation.navigateToMatchDetail
import com.eshc.goonersapp.feature.team.navigation.navigateToPlayerDetail
import com.eshc.goonersapp.feature.team.navigation.playerDetailScreen
import com.eshc.goonersapp.feature.team.navigation.teamHistoryScreen
import com.eshc.goonersapp.feature.team.navigation.teamScreen

@Composable
fun GnrNavHost(
    navController: NavHostController,
    onShowSnackbar : (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = homeNavigationRoute
    ){
        homeScreen(
            onShowSnackbar = onShowSnackbar
        )
        teamScreen(
            onPlayerClick = {
                navController.navigateToPlayerDetail(it)
            },
            onShowSnackbar = onShowSnackbar
        )
        playerDetailScreen(
            onShowSnackbar = onShowSnackbar
        )
        matchScreen(
            onClickDetail = {
                navController.navigateToMatchDetail(it.toUiModel())
            },
            onShowSnackbar = onShowSnackbar
        )
        matchDetailScreen(
            onClickChat = {
                navController.navigateToChatRoom(it)
            },
            onShowSnackbar = onShowSnackbar
        )
        teamHistoryScreen(
            onPlayerClick = {
                navController.navigateToPlayerDetail(it)
            },
            onShowSnackbar = onShowSnackbar
        )
        chatRoomScreen(
            onShowSnackbar = onShowSnackbar
        )
        clubDetailScreen(
            onShowSnackbar = onShowSnackbar
        )
    }
}