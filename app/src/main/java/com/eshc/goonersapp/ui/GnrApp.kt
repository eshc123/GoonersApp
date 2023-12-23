package com.eshc.goonersapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.eshc.goonersapp.core.designsystem.component.GnrNavigationBar
import com.eshc.goonersapp.core.designsystem.component.GnrNavigationBarItem
import com.eshc.goonersapp.feature.home.navigation.navigateToHome
import com.eshc.goonersapp.feature.team.TeamScreen
import com.eshc.goonersapp.feature.team.navigation.navigateToTeam
import com.eshc.goonersapp.feature.team.ui.SquadPlayerCard
import com.eshc.goonersapp.navigation.GnrNavHost
import com.eshc.goonersapp.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GnrApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            GnrBottomBar(
                destinations = TopLevelDestination.values().toList(),
                onNavigateToDestination = {
                    val topLevelNavOptions = navOptions {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    when (it) {
                        TopLevelDestination.HOME -> navController.navigateToHome(
                            navOptions = topLevelNavOptions
                        )
                        else -> navController.navigateToTeam(
                            navOptions = topLevelNavOptions
                        )
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        )
        {
            GnrNavHost(navController = navController)
        }
    }
}

@Composable
fun GnrBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    GnrNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            GnrNavigationBarItem(
                selected = false,
                onClick = {
                    onNavigateToDestination(destination)
                },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                        modifier= Modifier.size(24.dp)
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                        modifier= Modifier.size(24.dp)
                    )
                }
            )
        }

    }
}