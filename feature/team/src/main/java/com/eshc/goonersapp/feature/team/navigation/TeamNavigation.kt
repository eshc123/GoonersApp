package com.eshc.goonersapp.feature.team.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eshc.goonersapp.feature.team.detail.PlayerDetailScreen
import com.eshc.goonersapp.feature.team.TeamRoute

const val teamNavigationRoute = "team_route"
const val playerDetailNavigationRoute = "player_route"


internal const val playerIdArg = "playerId"

fun NavController.navigateToTeam(navOptions: NavOptions? = null) {
    this.navigate(teamNavigationRoute, navOptions)
}

fun NavController.navigateToPlayerDetail(playerId : String, navOptions: NavOptions? = null) {
    this.navigate(playerDetailNavigationRoute + "/${playerId}",navOptions)
}

fun NavGraphBuilder.teamScreen(
    onClick : (String) -> Unit
) {
    composable(
        route = teamNavigationRoute
    ) {
        TeamRoute(onClick)
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