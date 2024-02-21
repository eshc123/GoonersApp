package com.eshc.goonersapp.feature.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.usecase.chat.GetChatMessagesUseCase
import com.eshc.goonersapp.core.domain.usecase.chat.ConnectChatRoomUseCase
import com.eshc.goonersapp.core.domain.usecase.chat.DisconnectChatRoomUseCase
import com.eshc.goonersapp.core.domain.usecase.chat.SendChatMessageUseCase
import com.eshc.goonersapp.feature.chat.model.ChatMessageUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val connectChatRoomUseCase : ConnectChatRoomUseCase,
    private val getChatMessagesUseCase: GetChatMessagesUseCase,
    private val sendChatMessageUseCase : SendChatMessageUseCase,
    private val disconnectChatRoomUseCase: DisconnectChatRoomUseCase
) : ViewModel(){

    private val _chatMessages = MutableStateFlow<List<ChatMessageUiModel>>(emptyList())
    val chatMessages : StateFlow<List<ChatMessageUiModel>> = _chatMessages.asStateFlow()

    init {
        viewModelScope.launch {
            connectChatRoomUseCase()
            getChatMessagesUseCase().collect {
                _chatMessages.emit(
                    listOf(ChatMessageUiModel(it.message,it.messageType)) + chatMessages.value
                )
            }
        }
    }

    fun sendMessage(message : String){
        sendChatMessageUseCase(message)
    }

    override fun onCleared() {
        disconnectChatRoomUseCase()
        super.onCleared()
    }
}