package com.eshc.goonersapp.feature.match.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.feature.match.MatchRoute
import com.eshc.goonersapp.feature.match.detail.MatchDetailRootScreen
import com.eshc.goonersapp.feature.match.model.MatchType
import com.eshc.goonersapp.feature.match.model.MatchUiModel

const val matchNavigationRoute = "match_route"
const val matchDetailNavigationRoute = "match_detail_route"

internal const val matchArg = "match"

fun NavController.navigateToMatch(navOptions: NavOptions? = null) {
    this.navigate(matchNavigationRoute, navOptions)
}

fun NavController.navigateToMatchDetail(matchUiModel: MatchUiModel,navOptions: NavOptions? = null) {
    this.navigate("$matchDetailNavigationRoute?$matchArg=$matchUiModel", navOptions)
}

fun NavGraphBuilder.matchScreen(
    bottomBar : @Composable () -> Unit,
    onClickDetail : (Match) -> Unit,
    onClickUser : () -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = matchNavigationRoute
    ) {
        MatchRoute(
            bottomBar = bottomBar,
            onClickDetail = onClickDetail,
            onClickUser = onClickUser,
            onShowSnackbar = onShowSnackbar
        )
    }
}


fun NavGraphBuilder.matchDetailScreen(
    onBackIconClick: () -> Unit,
    onClickChat : (MatchUiModel) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = "$matchDetailNavigationRoute?$matchArg={$matchArg}",
        arguments = listOf(navArgument(matchArg) { type = MatchType })
    ) {
        MatchDetailRootScreen(
            onClickChat = onClickChat,
            onBackIconClick = onBackIconClick,
            onShowSnackbar = onShowSnackbar
        )
    }
}