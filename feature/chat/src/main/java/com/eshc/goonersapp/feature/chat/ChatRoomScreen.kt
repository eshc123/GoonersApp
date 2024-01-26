package com.eshc.goonersapp.feature.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.feature.chat.component.ChatMessageCard

@Composable
fun ChatRoomRoute() {
    ChatRoomScreen()
}


@Composable
fun ChatRoomScreen() {

    var message by remember {
        mutableStateOf(TextFieldValue())
    }

    var messageList by remember {
        mutableStateOf(listOf<String>())
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            reverseLayout = true
        ) {
            items(messageList) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    ChatMessageCard(text = it)
                }
            }
        }
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                value = message,
                maxLines = 1,
                onValueChange = {
                    message = it
                },
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .background(Color.LightGray, RoundedCornerShape(12.dp))
                            .padding(horizontal = 8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        innerTextField()
                    }

                }
            )
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(24.dp)
                    .clickable {
                        messageList = listOf(message.text) + messageList
                        message = TextFieldValue()
                    }
            )
        }
    }
}