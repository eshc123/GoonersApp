package com.eshc.goonersapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.iconpack.IcCalendarSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcCalendarUnselected
import com.eshc.goonersapp.core.designsystem.iconpack.IcHomeSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcHomeUnselected
import com.eshc.goonersapp.core.designsystem.iconpack.IcTeamSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcTeamUnselected
import com.eshc.goonersapp.feature.home.navigation.homeNavigationRoute
import com.eshc.goonersapp.feature.match.navigation.matchNavigationRoute
import com.eshc.goonersapp.feature.team.navigation.teamNavigationRoute
import com.eshc.goonersapp.feature.home.R as home
import com.eshc.goonersapp.feature.match.R as match
import com.eshc.goonersapp.feature.team.R as team

val topLevelDestinationSet = TopLevelDestination.entries
    .map { destination -> destination.route }
    .toSet()

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
    val route : String
) {
    HOME(
        selectedIcon = IconPack.IcHomeSelected,
        unselectedIcon = IconPack.IcHomeUnselected,
        iconTextId = home.string.home,
        titleTextId = home.string.home,
        route = homeNavigationRoute
    ),
    MATCH(
        selectedIcon = IconPack.IcCalendarSelected,
        unselectedIcon = IconPack.IcCalendarUnselected,
        iconTextId = match.string.match,
        titleTextId = match.string.match,
        route = matchNavigationRoute
    ),
    TEAM(
        selectedIcon = IconPack.IcTeamSelected,
        unselectedIcon = IconPack.IcTeamUnselected,
        iconTextId = team.string.team,
        titleTextId = team.string.team,
        route = teamNavigationRoute
    ),
//    PLAYGROUND(
//        selectedIcon = IconPack.IcPlaygroundSelected,
//        unselectedIcon = IconPack.IcPlaygroundUnselected,
//        iconTextId = playground.string.playground,
//        titleTextId = playground.string.playground
//    )
}