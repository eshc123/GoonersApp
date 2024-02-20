package com.eshc.goonersapp.core.domain.usecase

import com.eshc.goonersapp.core.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JoinChatRoomUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {

    operator fun invoke(): Flow<Boolean> =
        chatRepository.joinChatRoom()
}