package com.eshc.goonersapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.eshc.goonersapp.feature.chat.navigation.chatRoomScreen
import com.eshc.goonersapp.feature.chat.navigation.navigateToChatRoom
import com.eshc.goonersapp.feature.home.navigation.homeNavigationRoute
import com.eshc.goonersapp.feature.home.navigation.homeScreen
import com.eshc.goonersapp.feature.login.navigation.loginScreen
import com.eshc.goonersapp.feature.login.navigation.navigateToSignUp
import com.eshc.goonersapp.feature.login.navigation.signUpScreen
import com.eshc.goonersapp.feature.match.model.toUiModel
import com.eshc.goonersapp.feature.match.navigation.matchDetailScreen
import com.eshc.goonersapp.feature.match.navigation.matchScreen
import com.eshc.goonersapp.feature.team.navigation.clubDetailScreen
import com.eshc.goonersapp.feature.match.navigation.navigateToMatchDetail
import com.eshc.goonersapp.feature.team.navigation.navigateToPlayerDetail
import com.eshc.goonersapp.feature.team.navigation.playerDetailScreen
import com.eshc.goonersapp.feature.team.navigation.teamSearchScreen
import com.eshc.goonersapp.feature.team.navigation.teamScreen

const val mainNavigationRoute = "main_route"

@Composable
fun GnrNavHost(
    modifier : Modifier = Modifier,
    navController: NavHostController,
    onShowSnackbar : (String) -> Unit,
    topBar : @Composable (TopLevelDestination) -> Unit,
    bottomBar : @Composable () -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = mainNavigationRoute
    ){
        navigation(
            startDestination = homeNavigationRoute,
            route = mainNavigationRoute
        ){
            homeScreen(
                topBar = {
                    topBar(TopLevelDestination.HOME)
                },
                bottomBar = bottomBar,
                onShowSnackbar = onShowSnackbar
            )
            teamScreen(
                topBar = {
                    topBar(TopLevelDestination.TEAM)
                },
                bottomBar = bottomBar,
                onPlayerClick = {
                    navController.navigateToPlayerDetail(it)
                },
                onShowSnackbar = onShowSnackbar
            )
            matchScreen(
                topBar = {
                    topBar(TopLevelDestination.MATCH)
                },
                bottomBar = bottomBar,
                onClickDetail = {
                    navController.navigateToMatchDetail(it.toUiModel())
                },
                onShowSnackbar = onShowSnackbar
            )
        }

        playerDetailScreen(
            onShowSnackbar = onShowSnackbar
        )

        matchDetailScreen(
            bottomBar = bottomBar,
            onClickChat = { navController.navigateToChatRoom(it) },
            onBackIconClick = { navController.popBackStack() },
            onShowSnackbar = onShowSnackbar
        )

        teamSearchScreen(
            bottomBar = bottomBar,
            onPlayerClick = { navController.navigateToPlayerDetail(it) },
            onBackIconClick = { navController.popBackStack() },
            onShowSnackbar = onShowSnackbar
        )

        chatRoomScreen(
            onShowSnackbar = onShowSnackbar
        )

        clubDetailScreen(
            onBackIconClick = { navController.popBackStack() },
            onShowSnackbar = onShowSnackbar
        )

        loginScreen(
            onShowSnackbar = onShowSnackbar,
            onClickSignUp = {
                navController.navigateToSignUp()
            }
        )

        signUpScreen(
            onShowSnackbar = onShowSnackbar
        )
    }
}