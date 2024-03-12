package com.eshc.goonersapp.feature.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.eshc.goonersapp.feature.login.LoginScreen
import com.eshc.goonersapp.feature.login.SignUpScreen

const val loginNavigationRoute = "login_route"
const val signUpNavigationRoute = "sign_up_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavController.navigateToSignUp(navOptions: NavOptions? = null) {
    this.navigate(signUpNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(
    onShowSnackbar : (String) -> Unit,
    onClickSignUp : () -> Unit
) {
    composable(
        route = loginNavigationRoute
    ) {
        LoginScreen(
            onShowSnackbar = onShowSnackbar,
            onClickSignUp = onClickSignUp
        )
    }
}

fun NavGraphBuilder.signUpScreen(
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = signUpNavigationRoute
    ) {
        SignUpScreen(
            onShowSnackbar = onShowSnackbar
        )
    }
}
