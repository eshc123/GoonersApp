package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.RemoteChatMessage
import kotlinx.coroutines.flow.Flow

interface ChatNetworkDataSource {

    suspend fun connectChatRoom()

    fun getChatMessages() : Flow<RemoteChatMessage>

    fun sendChatMessage(message : String)

    fun disconnectChatRoom()

}