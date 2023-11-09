package com.eshc.goonersapp.feature.team.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.eshc.goonersapp.feature.team.TeamRoute

const val teamNavigationRoute = "team_route"

fun NavController.navigateToTeam(navOptions: NavOptions? = null) {
    this.navigate(teamNavigationRoute, navOptions)
}

fun NavGraphBuilder.teamScreen() {
    composable(
        route = teamNavigationRoute
    ) {
        TeamRoute()
    }
}
