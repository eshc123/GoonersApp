package com.eshc.goonersapp.feature.team.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eshc.goonersapp.feature.team.detail.PlayerDetailScreen
import com.eshc.goonersapp.feature.team.TeamRoute
import com.eshc.goonersapp.feature.team.club.ClubDetailRoute
import com.eshc.goonersapp.feature.team.club.ClubDetailScreen
import com.eshc.goonersapp.feature.team.history.TeamHistoryScreen

const val teamNavigationRoute = "team_route"
const val playerDetailNavigationRoute = "player_route"
const val teamHistoryNavigationRoute = "team_history_route"
const val clubDetailNavigationRoute = "club_detail_route"


internal const val playerIdArg = "playerId"

fun NavController.navigateToTeam(navOptions: NavOptions? = null) {
    this.navigate(teamNavigationRoute, navOptions)
}

fun NavController.navigateToPlayerDetail(playerId : String, navOptions: NavOptions? = null) {
    this.navigate(playerDetailNavigationRoute + "/${playerId}",navOptions)
}

fun NavController.navigateToTeamHistory(navOptions: NavOptions? = null) {
    this.navigate(teamHistoryNavigationRoute, navOptions)
}

fun NavController.navigateToClubDetail(navOptions: NavOptions? = null) {
    this.navigate(clubDetailNavigationRoute, navOptions)
}

fun NavGraphBuilder.teamScreen(
    onPlayerClick : (String) -> Unit
) {
    composable(
        route = teamNavigationRoute
    ) {
        TeamRoute(
            onPlayerClick
        )
    }
}

fun NavGraphBuilder.playerDetailScreen() {
    composable(
        route = "$playerDetailNavigationRoute/{$playerIdArg}",
        arguments = listOf(
            navArgument(playerIdArg) { type = NavType.StringType },
        ),
    ) {
        PlayerDetailScreen()
    }
}

fun NavGraphBuilder.teamHistoryScreen(
    onPlayerClick : (String) -> Unit
) {
    composable(
        route = teamHistoryNavigationRoute
    ) {
        TeamHistoryScreen(onPlayerClick)
    }
}

fun NavGraphBuilder.clubDetailScreen(

) {
    composable(
        route = clubDetailNavigationRoute
    ) {
        ClubDetailRoute()
    }
}