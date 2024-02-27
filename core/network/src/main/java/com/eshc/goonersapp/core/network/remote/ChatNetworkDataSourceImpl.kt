package com.eshc.goonersapp.core.network.remote

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import com.eshc.goonersapp.core.network.ChatNetworkDataSource
import com.eshc.goonersapp.core.network.model.chat.RemoteChatMessage
import dagger.hilt.android.qualifiers.ApplicationContext
import io.socket.client.Socket
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ChatNetworkDataSourceImpl @Inject constructor(
    private val socket: Socket,
    @ApplicationContext private val applicationContext: Context
) : ChatNetworkDataSource {

    @SuppressLint("HardwareIds")
    private val deviceId =
        Settings.Secure.getString(applicationContext.contentResolver, Settings.Secure.ANDROID_ID)

    override suspend fun connectChatRoom() {
        socket.connect()
    }

    override fun getChatMessages(): Flow<RemoteChatMessage> = callbackFlow {
        socket.on(Socket.EVENT_CONNECT) {
            trySend(RemoteChatMessage.Connected)
        }

        socket.on(Socket.EVENT_CONNECT_ERROR) {
            trySend(RemoteChatMessage.Error)
        }
        socket.on(Socket.EVENT_DISCONNECT){
            trySend(RemoteChatMessage.Disconnected)
        }
        socket.on("noti_chatMessage"){
            trySend(
                RemoteChatMessage.Message(
                    it[1].toString(),
                    it[0].toString() == deviceId
                )
            )
        }

        awaitClose {

        }
    }

    override fun sendChatMessage(message: String) {
        socket.emit("req_chatMessage", deviceId.toString(), message)
    }

    override fun disconnectChatRoom() {
        socket.disconnect()
    }
}
