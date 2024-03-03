package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.chat.ChatMessage
import com.eshc.goonersapp.core.domain.model.chat.MessageType
import com.eshc.goonersapp.core.network.model.chat.RemoteChatMessage

fun RemoteChatMessage.Message.toModel() = ChatMessage(
    message = message,
    messageType = if(isMine) MessageType.Mine else MessageType.Others
)