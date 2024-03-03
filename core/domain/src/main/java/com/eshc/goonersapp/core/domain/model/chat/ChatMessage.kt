package com.eshc.goonersapp.core.domain.model.chat

data class ChatMessage(
    val message : String,
    val messageType: MessageType = MessageType.System
)

enum class MessageType {
    Mine, Others, System
}