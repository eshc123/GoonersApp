package com.eshc.goonersapp.core.domain.usecase.chat

import com.eshc.goonersapp.core.domain.model.chat.ChatMessage
import com.eshc.goonersapp.core.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetChatMessagesUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {

    operator fun invoke(): Flow<ChatMessage> =
        chatRepository.getChatMessages()
}