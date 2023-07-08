package com.eshc.goonersapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.eshc.goonersapp.feature.match.R as match
import com.eshc.goonersapp.feature.team.R as team
import com.eshc.goonersapp.feature.history.R as history

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int
){
    HISTORY(
        selectedIcon = Icons.Rounded.List,
        unselectedIcon = Icons.Outlined.List,
        iconTextId = history.string.history,
        titleTextId = history.string.history
    ),
    MATCH(
    selectedIcon = Icons.Rounded.Info,
    unselectedIcon = Icons.Outlined.Info,
    iconTextId = match.string.match,
    titleTextId = match.string.match
    ),
    TEAM(
    selectedIcon = Icons.Rounded.AccountCircle,
    unselectedIcon = Icons.Outlined.AccountCircle,
    iconTextId = team.string.team,
    titleTextId = team.string.team
    )
}