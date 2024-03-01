package com.eshc.goonersapp.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.eshc.goonersapp.feature.home.HomeRoute

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = homeNavigationRoute
    ) {
        HomeRoute(
            onShowSnackbar = onShowSnackbar
        )
    }
}
