package com.eshc.goonersapp.feature.chat.model

import com.eshc.goonersapp.core.domain.model.chat.MessageType

data class ChatMessageUiModel(
    val message : String,
    val messageType: MessageType
)
