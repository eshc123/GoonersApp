package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.ChatNetworkDataSource
import io.socket.client.Socket
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ChatNetworkDataSourceImpl  @Inject constructor(
    private val socket: Socket
) : ChatNetworkDataSource {
    override suspend fun joinChatRoom(): Boolean = suspendCoroutine { continuation ->
        socket.on(Socket.EVENT_CONNECT){
            continuation.resume(true)
        }
        socket.on(Socket.EVENT_CONNECT_ERROR){
            continuation.resume(false)
        }
        socket.connect()
    }

    override fun getChatMessages(): Flow<String> = callbackFlow {
        socket.on("noti_chatMessage") {
            trySend(it.joinToString(","))
        }

        awaitClose {
            socket.disconnect()
        }
    }

    override fun sendChatMessage(message : String) {
        socket.emit("req_chatMessage", message)
    }

    override fun disconnectChatRoom() {
        socket.disconnect()
    }
}
