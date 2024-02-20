package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.domain.repository.ChatRepository
import com.eshc.goonersapp.core.network.ChatNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatNetworkDataSource: ChatNetworkDataSource
) : ChatRepository {


    override fun joinChatRoom(): Flow<Boolean> = flow {
        emit(chatNetworkDataSource.joinChatRoom())
    }

    override fun getChatMessages(): Flow<String> {
        return chatNetworkDataSource.getChatMessages()
    }

    override fun sendChatMessage(message: String) {
        return chatNetworkDataSource.sendChatMessage(message)
    }
}