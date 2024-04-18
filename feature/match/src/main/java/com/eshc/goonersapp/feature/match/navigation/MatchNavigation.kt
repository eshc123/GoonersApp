package com.eshc.goonersapp.feature.match.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.feature.match.MatchRoute
import com.eshc.goonersapp.feature.match.detail.MatchDetailRoute
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
    topBar : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
    onClickDetail : (Match) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = matchNavigationRoute
    ) {
        MatchRoute(
            topBar = topBar,
            bottomBar = bottomBar,
            onClickDetail = onClickDetail,
            onShowSnackbar = onShowSnackbar
        )
    }
}


fun NavGraphBuilder.matchDetailScreen(
    onClickChat : (MatchUiModel) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = "$matchDetailNavigationRoute?$matchArg={$matchArg}",
        arguments = listOf(
            navArgument(matchArg) { type = MatchType },
        ),
    ) {
        MatchDetailRoute(
            onClickChat = onClickChat,
            onShowSnackbar = onShowSnackbar
        )
    }
}