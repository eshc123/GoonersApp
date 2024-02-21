package com.eshc.goonersapp.core.domain.usecase.chat

import com.eshc.goonersapp.core.domain.repository.ChatRepository
import javax.inject.Inject

class ConnectChatRoomUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {

    suspend operator fun invoke(){
        chatRepository.connectChatRoom()
    }

}