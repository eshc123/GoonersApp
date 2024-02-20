package com.eshc.goonersapp.core.network

import kotlinx.coroutines.flow.Flow

interface ChatNetworkDataSource {

    suspend fun joinChatRoom() : Boolean

    fun getChatMessages() : Flow<String>

    fun sendChatMessage(message : String)

}