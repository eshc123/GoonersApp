package com.eshc.goonersapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.eshc.goonersapp.core.data.util.NetworkConnectivityManager
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrNavigationBar
import com.eshc.goonersapp.core.designsystem.component.GnrNavigationBarItem
import com.eshc.goonersapp.core.designsystem.component.GnrTopLevelTopBar
import com.eshc.goonersapp.core.designsystem.iconpack.IcGridCalender
import com.eshc.goonersapp.core.designsystem.iconpack.IcInfo
import com.eshc.goonersapp.core.designsystem.iconpack.IcNotification
import com.eshc.goonersapp.core.designsystem.iconpack.IcPeople
import com.eshc.goonersapp.core.designsystem.iconpack.IcSearch
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.home.navigation.navigateToHome
import com.eshc.goonersapp.feature.login.navigation.navigateToLogin
import com.eshc.goonersapp.feature.match.navigation.navigateToMatch
import com.eshc.goonersapp.feature.team.navigation.navigateToClubDetail
import com.eshc.goonersapp.feature.team.navigation.navigateToTeam
import com.eshc.goonersapp.feature.team.navigation.navigateToSearch
import com.eshc.goonersapp.navigation.GnrNavHost
import com.eshc.goonersapp.navigation.TopLevelDestination
import kotlinx.coroutines.launch

@Composable
fun GnrApp(
    networkConnectivityManager: NetworkConnectivityManager
) {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val isOnline by networkConnectivityManager.isOnline.collectAsStateWithLifecycle(initialValue = true)

    LaunchedEffect(key1 = isOnline) {
        if(isOnline.not()){
            snackbarHostState.showSnackbar(
                "You aren’t connected to the internet",
                duration = SnackbarDuration.Indefinite
            )
        }
    }

    Scaffold(
        modifier = Modifier,
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            GnrNavHost(
                navController = navController,
                onShowSnackbar = { message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message)
                    }
                },
                topBar = { topLevelDestination ->
                    GnrTopLevelBar(
                        topLevelDestination = topLevelDestination,
                        icons = {
                            when (topLevelDestination) {
                                TopLevelDestination.HOME -> {
                                    Icon(
                                        imageVector = IconPack.IcNotification,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(24.dp)
                                            .clip(RoundedCornerShape(3.dp)),
                                        tint = ColorFF777777
                                    )
                                    Icon(
                                        imageVector = IconPack.IcPeople,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(24.dp)
                                            .clip(RoundedCornerShape(3.dp))
                                            .clickable { navController.navigateToLogin() },
                                        tint = ColorFF777777
                                    )
                                }

                                TopLevelDestination.MATCH -> {
                                    Icon(
                                        imageVector = IconPack.IcGridCalender,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(24.dp)
                                            .clip(RoundedCornerShape(3.dp)),
                                        tint = ColorFF777777
                                    )
                                    Icon(
                                        imageVector = IconPack.IcPeople,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(24.dp)
                                            .clip(RoundedCornerShape(3.dp))
                                            .clickable { navController.navigateToLogin() },
                                        tint = ColorFF777777
                                    )
                                }

                                TopLevelDestination.TEAM -> {
                                    Icon(
                                        imageVector = IconPack.IcInfo,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(24.dp)
                                            .clip(RoundedCornerShape(3.dp))
                                            .clickable { navController.navigateToClubDetail() },
                                        tint = ColorFF777777
                                    )
                                    Icon(
                                        imageVector = IconPack.IcSearch,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(24.dp)
                                            .clip(RoundedCornerShape(3.dp))
                                            .clickable { navController.navigateToSearch() },
                                        tint = ColorFF777777
                                    )
                                }
                            }
                        }
                    )
                },
                bottomBar = {
                    GnrBottomBar(
                        destinations = TopLevelDestination.entries,
                        currentDestination = navController.currentBackStackEntryAsState().value?.destination,
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
            )

        }

    }
}

@Composable
fun GnrTopLevelBar(
    topLevelDestination: TopLevelDestination,
    icons: @Composable () -> Unit
) {
    GnrTopLevelTopBar(
        modifier = Modifier.padding(horizontal = 8.dp),
        title = stringResource(id = topLevelDestination.titleTextId)
    ) {
        icons()
    }
}

@Composable
fun GnrBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    GnrNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)

            GnrNavigationBarItem(
                selected = selected,
                onClick = {
                    onNavigateToDestination(destination)
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .heightIn(max = 18.dp),
                        imageVector = destination.unselectedIcon,
                        tint = ColorFF9E9E9E,
                        contentDescription = null,
                    )
                },
                selectedIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .heightIn(max = 18.dp),
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = destination.iconTextId),
                        style = GnrTypography.body2Regular.copy(
                            color = if(selected) ColorFF181818 else ColorFF9E9E9E
                        )
                    )
                }
            )
        }

    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false