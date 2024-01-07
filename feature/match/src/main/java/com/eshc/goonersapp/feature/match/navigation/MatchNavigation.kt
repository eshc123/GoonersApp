package com.eshc.goonersapp.feature.match.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.eshc.goonersapp.feature.match.MatchRoute

const val homeNavigationMatch = "match_route"

fun NavController.navigateToMatch(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationMatch, navOptions)
}

fun NavGraphBuilder.matchScreen() {
    composable(
        route = homeNavigationMatch
    ) {
        MatchRoute()
    }
}