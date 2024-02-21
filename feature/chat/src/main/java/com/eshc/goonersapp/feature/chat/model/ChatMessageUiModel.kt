package com.eshc.goonersapp.feature.chat.model

import com.eshc.goonersapp.core.domain.model.MessageType

data class ChatMessageUiModel(
    val message : String,
    val messageType: MessageType
)
