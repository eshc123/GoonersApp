package com.eshc.goonersapp.core.domain.usecase.chat

import com.eshc.goonersapp.core.domain.repository.ChatRepository
import javax.inject.Inject

class DisconnectChatRoomUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {

    operator fun invoke(){
        chatRepository.disconnectChatRoom()
    }

}