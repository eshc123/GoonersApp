package com.eshc.goonersapp.feature.chat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eshc.goonersapp.feature.chat.ChatRoomRoute
import com.eshc.goonersapp.feature.match.model.MatchType
import com.eshc.goonersapp.feature.match.model.MatchUiModel
import com.eshc.goonersapp.feature.match.navigation.matchDetailNavigationRoute

const val chatRoomNavigationRoute = "chatRoom_route"

internal const val matchArg = "match"


fun NavController.navigateToChatRoom(matchUiModel: MatchUiModel, navOptions: NavOptions? = null) {
    this.navigate("$chatRoomNavigationRoute?${matchArg}=$matchUiModel", navOptions)
}

fun NavGraphBuilder.chatRoomScreen(
    onShowSnackbar : (String) -> Unit
) {
    composable(
        route = "$chatRoomNavigationRoute?${matchArg}={$matchArg}",
        arguments = listOf(
            navArgument(matchArg) { type = MatchType },
        ),
    ) {
        ChatRoomRoute(
            onShowSnackbar = onShowSnackbar
        )
    }
}