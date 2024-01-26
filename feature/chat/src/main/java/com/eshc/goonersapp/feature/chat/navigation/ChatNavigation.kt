package com.eshc.goonersapp.feature.chat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.eshc.goonersapp.feature.chat.ChatRoomRoute

const val chatRoomNavigationRoute = "chatRoom_route"

fun NavController.navigateToChatRoom(navOptions: NavOptions? = null) {
    this.navigate(chatRoomNavigationRoute, navOptions)
}

fun NavGraphBuilder.chatRoomScreen() {
    composable(
        route = chatRoomNavigationRoute
    ) {
        ChatRoomRoute()
    }
}