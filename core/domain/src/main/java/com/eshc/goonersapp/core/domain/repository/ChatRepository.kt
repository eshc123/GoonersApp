package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.chat.ChatMessage
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    suspend fun connectChatRoom()

    fun getChatMessages() : Flow<ChatMessage>

    fun sendChatMessage(message : String)

    fun disconnectChatRoom()
}