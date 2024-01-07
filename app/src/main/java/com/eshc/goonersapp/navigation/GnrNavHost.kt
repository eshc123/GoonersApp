package com.eshc.goonersapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.eshc.goonersapp.feature.home.navigation.homeNavigationRoute
import com.eshc.goonersapp.feature.home.navigation.homeScreen
import com.eshc.goonersapp.feature.match.navigation.matchScreen
import com.eshc.goonersapp.feature.team.navigation.navigateToPlayerDetail
import com.eshc.goonersapp.feature.team.navigation.playerDetailScreen
import com.eshc.goonersapp.feature.team.navigation.teamScreen

@Composable
fun GnrNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = homeNavigationRoute
    ){
        homeScreen()
        teamScreen(
            onClick = {
                navController.navigateToPlayerDetail(it)
            }
        )
        playerDetailScreen()
        matchScreen()
    }
}