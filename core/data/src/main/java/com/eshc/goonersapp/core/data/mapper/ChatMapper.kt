package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.ChatMessage
import com.eshc.goonersapp.core.domain.model.MessageType
import com.eshc.goonersapp.core.network.model.chat.RemoteChatMessage

fun RemoteChatMessage.Message.toModel() = ChatMessage(
    message = message,
    messageType = if(isMine) MessageType.Mine else MessageType.Others
)