package com.eshc.goonersapp.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun joinChatRoom() : Flow<Boolean>

    fun getChatMessages() : Flow<String>

    fun sendChatMessage(message : String)
}