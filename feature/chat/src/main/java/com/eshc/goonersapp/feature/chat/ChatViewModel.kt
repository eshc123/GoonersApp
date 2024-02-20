package com.eshc.goonersapp.feature.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.usecase.GetChatMessagesUseCase
import com.eshc.goonersapp.core.domain.usecase.JoinChatRoomUseCase
import com.eshc.goonersapp.core.domain.usecase.SendChatMessageUseCase
import com.eshc.goonersapp.feature.chat.model.ChatMessageUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val joinChatRoomUseCase : JoinChatRoomUseCase,
    private val getChatMessagesUseCase: GetChatMessagesUseCase,
    private val sendChatMessageUseCase : SendChatMessageUseCase
) : ViewModel(){

    private val _chatMessages = MutableStateFlow<List<ChatMessageUiModel>>(emptyList())
    val chatMessages : StateFlow<List<ChatMessageUiModel>> = _chatMessages.asStateFlow()

    init {
        viewModelScope.launch {
            joinChatRoomUseCase().collect {
                if(it){
                    getChatMessagesUseCase().collect {
                        _chatMessages.emit(
                            listOf(ChatMessageUiModel(it,false)) + chatMessages.value
                        )
                    }
                }

            }

        }
    }

    fun addMessageAsMine(message: String){
        viewModelScope.launch {
            _chatMessages.emit(
                listOf(ChatMessageUiModel(message,true)) + chatMessages.value
            )
        }
    }

    fun sendMessage(message : String){
        sendChatMessageUseCase(message)
    }
}