package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.ChatMessage
import com.eshc.goonersapp.core.domain.repository.ChatRepository
import com.eshc.goonersapp.core.network.ChatNetworkDataSource
import com.eshc.goonersapp.core.network.model.chat.RemoteChatMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatNetworkDataSource: ChatNetworkDataSource
) : ChatRepository {


    override suspend  fun connectChatRoom(){
        chatNetworkDataSource.connectChatRoom()
    }

    override fun getChatMessages(): Flow<ChatMessage> {
        return chatNetworkDataSource.getChatMessages().map {
            when(it){
                is RemoteChatMessage.Message -> it.toModel()
                is RemoteChatMessage.Connected -> ChatMessage("You've joined the chat room")
                is RemoteChatMessage.Disconnected -> ChatMessage("You've left the chat room")
                is RemoteChatMessage.Error -> ChatMessage("Error")
            }
        }
    }

    override fun sendChatMessage(message: String) {
        return chatNetworkDataSource.sendChatMessage(message)
    }

    override fun disconnectChatRoom() {
        chatNetworkDataSource.disconnectChatRoom()
    }
}