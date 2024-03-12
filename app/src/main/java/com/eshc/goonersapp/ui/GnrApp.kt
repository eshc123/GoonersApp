package com.eshc.goonersapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrNavigationBar
import com.eshc.goonersapp.core.designsystem.component.GnrNavigationBarItem
import com.eshc.goonersapp.core.designsystem.component.TopLevelTopBar
import com.eshc.goonersapp.core.designsystem.iconpack.IcFootballClub
import com.eshc.goonersapp.core.designsystem.iconpack.IcInfo
import com.eshc.goonersapp.core.designsystem.iconpack.IcSearch
import com.eshc.goonersapp.core.designsystem.iconpack.IcUser
import com.eshc.goonersapp.feature.chat.navigation.navigateToChatRoom
import com.eshc.goonersapp.feature.home.navigation.navigateToHome
import com.eshc.goonersapp.feature.login.navigation.navigateToLogin
import com.eshc.goonersapp.feature.match.navigation.navigateToMatch
import com.eshc.goonersapp.feature.team.navigation.navigateToClubDetail
import com.eshc.goonersapp.feature.team.navigation.navigateToTeam
import com.eshc.goonersapp.feature.team.navigation.navigateToTeamHistory
import com.eshc.goonersapp.navigation.GnrNavHost
import com.eshc.goonersapp.navigation.TopLevelDestination
import com.eshc.goonersapp.navigation.topLevelDestinationSet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GnrApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        bottomBar = {
            if (topLevelDestinationSet.contains(currentRoute)){
                GnrBottomBar(
                    destinations = TopLevelDestination.entries,
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
                                topLevelNavOptions
                            )

                            TopLevelDestination.MATCH -> navController.navigateToMatch(
                                topLevelNavOptions
                            )

                            else -> navController.navigateToTeam(
                                topLevelNavOptions
                            )
                        }
                    }
                )
            }

        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        )
        {
            if (topLevelDestinationSet.contains(currentRoute)) {
                TopLevelDestination.entries.find { it.route == currentRoute }
                    ?.let { topLevelDestination ->
                        GnrTopLevelBar(
                            topLevelDestination = topLevelDestination,
                            icons = {
                                when (topLevelDestination) {
                                    TopLevelDestination.TEAM -> {
                                        Icon(
                                            imageVector = IconPack.IcInfo,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .padding(horizontal = 8.dp)
                                                .size(24.dp)
                                                .clickable {
                                                    navController.navigateToClubDetail()
                                                }
                                        )
                                        Icon(
                                            imageVector = IconPack.IcSearch,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .padding(horizontal = 8.dp)
                                                .size(24.dp)
                                                .clickable {
                                                    navController.navigateToTeamHistory()
                                                }
                                        )
                                    }

                                    TopLevelDestination.HOME -> {
                                        Icon(
                                            imageVector = IconPack.IcUser,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .padding(horizontal = 8.dp)
                                                .size(24.dp)
                                                .clickable {
                                                    navController.navigateToLogin()
                                                }
                                        )
                                    }

                                    else -> {

                                    }
                                }


                            }
                        )
                    }

            }

            GnrNavHost(
                navController = navController,
                onShowSnackbar = { message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun GnrTopLevelBar(
    topLevelDestination: TopLevelDestination,
    icons: @Composable () -> Unit
) {
    TopLevelTopBar(
        modifier = Modifier.padding(horizontal = 8.dp),
        title = topLevelDestination.name
    ) {
        icons()
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
                        modifier = Modifier.size(24.dp)
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }

    }
}