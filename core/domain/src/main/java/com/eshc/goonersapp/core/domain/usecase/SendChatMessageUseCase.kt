package com.eshc.goonersapp.core.domain.usecase

import com.eshc.goonersapp.core.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SendChatMessageUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {

    operator fun invoke(message : String) =
        chatRepository.sendChatMessage(message)
}