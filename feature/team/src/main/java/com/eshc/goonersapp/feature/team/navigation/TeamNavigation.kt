package com.eshc.goonersapp.feature.team.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eshc.goonersapp.feature.team.TeamScreen
import com.eshc.goonersapp.feature.team.club.ClubDetailRoute
import com.eshc.goonersapp.feature.team.detail.PlayerDetailRootScreen
import com.eshc.goonersapp.feature.team.history.TeamHistoryScreen

const val teamNavigationRoute = "team_route"
const val playerDetailNavigationRoute = "player_route"
const val teamHistoryNavigationRoute = "team_history_route"
const val clubDetailNavigationRoute = "club_detail_route"


internal const val playerIdArg = "playerId"

fun NavController.navigateToTeam(navOptions: NavOptions? = null) {
    this.navigate(teamNavigationRoute, navOptions)
}

fun NavController.navigateToPlayerDetail(playerId: String, navOptions: NavOptions? = null) {
    this.navigate(playerDetailNavigationRoute + "/${playerId}", navOptions)
}

fun NavController.navigateToTeamHistory(navOptions: NavOptions? = null) {
    this.navigate(teamHistoryNavigationRoute, navOptions)
}

fun NavController.navigateToClubDetail(navOptions: NavOptions? = null) {
    this.navigate(clubDetailNavigationRoute, navOptions)
}

fun NavGraphBuilder.teamScreen(
    topBar : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
    onPlayerClick: (String) -> Unit,
    onShowSnackbar: (String) -> Unit
) {
    composable(
        route = teamNavigationRoute
    ) {
        TeamScreen(
            topBar = topBar,
            bottomBar = bottomBar,
            onPlayerClick,
            onShowSnackbar
        )
    }
}

fun NavGraphBuilder.playerDetailScreen(
    onShowSnackbar: (String) -> Unit
) {
    composable(
        route = "$playerDetailNavigationRoute/{$playerIdArg}",
        arguments = listOf(
            navArgument(playerIdArg) { type = NavType.StringType },
        ),
    ) {
        PlayerDetailRootScreen(
            onShowSnackbar = onShowSnackbar
        )
    }
}

fun NavGraphBuilder.teamHistoryScreen(
    onPlayerClick: (String) -> Unit,
    onShowSnackbar: (String) -> Unit
) {
    composable(
        route = teamHistoryNavigationRoute
    ) {
        TeamHistoryScreen(
            onPlayerClick,
            onShowSnackbar
        )
    }
}

fun NavGraphBuilder.clubDetailScreen(
    onShowSnackbar: (String) -> Unit
) {
    composable(
        route = clubDetailNavigationRoute
    ) {
        ClubDetailRoute(
            onShowSnackbar = onShowSnackbar
        )
    }
}