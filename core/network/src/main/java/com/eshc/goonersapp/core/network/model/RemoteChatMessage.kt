package com.eshc.goonersapp.core.network.model

sealed class RemoteChatMessage{
    data object Connected : RemoteChatMessage()
    data object Disconnected : RemoteChatMessage()
    data object Error : RemoteChatMessage()
    data class Message(
        val message : String,
        val isMine : Boolean
    ) : RemoteChatMessage()
}
