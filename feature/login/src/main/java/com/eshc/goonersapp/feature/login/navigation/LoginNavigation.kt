package com.eshc.goonersapp.feature.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.eshc.goonersapp.feature.login.LoginScreen

const val loginNavigationRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = loginNavigationRoute
    ) {
        LoginScreen(
            onShowSnackbar = onShowSnackbar
        )
    }
}
