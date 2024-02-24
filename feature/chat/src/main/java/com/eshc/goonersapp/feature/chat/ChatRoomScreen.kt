package com.eshc.goonersapp.feature.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.component.ImageCard
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.MessageType
import com.eshc.goonersapp.feature.chat.component.ChatMessageCard

@Composable
fun ChatRoomRoute(
    viewModel: ChatViewModel = hiltViewModel()
) {
    ChatRoomScreen(viewModel)
}


@Composable
fun ChatRoomScreen(
    viewModel: ChatViewModel
) {

    val match by viewModel.match.collectAsStateWithLifecycle()

    var message by remember {
        mutableStateOf(TextFieldValue())
    }

    val messageList by viewModel.chatMessages.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f)
            ) {
                Text(
                    text = DateUtil.getYearAndMonthAndDateAndTimeString(match.matchDate),
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = match.stadiumName,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
            ImageCard(backgroundColor = Color(0xFF151D2D)) {
                AsyncImage(
                    model = "https://www.arsenal.com/sites/default/files/styles/small/public/logos/comp_8.png?auto=webp&itok=EBszNKBn",
                    contentDescription = null
                )
            }

        }





        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 6.dp, horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AsyncImage(
                modifier = Modifier.width(64.dp),
                model = match.homeTeamImageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = if (match.isFinished) "${match.homeScore} : ${match.awayScore}" else "  vs  ",
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp,
                letterSpacing = 0.1.sp
            )
            AsyncImage(
                modifier = Modifier.width(64.dp),
                model = match.awayTeamImageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }

        Divider(
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxWidth(), thickness = 8.dp, color = Color(0xFFE4E4E4)
        )



        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            reverseLayout = true
        ) {
            items(messageList) { chatMessage ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = when (chatMessage.messageType) {
                        MessageType.Mine -> Alignment.CenterEnd
                        MessageType.Others -> Alignment.CenterStart
                        MessageType.System -> Alignment.Center
                    }
                ) {
                    when (chatMessage.messageType) {
                        MessageType.System ->
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = chatMessage.message,
                                fontFamily = pretendard,
                                fontWeight = FontWeight.Normal,
                                color = Color.LightGray
                            )

                        else -> ChatMessageCard(
                            text = chatMessage.message,
                            isMine = chatMessage.messageType == MessageType.Mine
                        )
                    }

                }
            }
        }
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                value = message,
                maxLines = 1,
                textStyle = TextStyle(
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                ),
                onValueChange = {
                    message = it
                },
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .background(Color(0xFFF1F1F1), CircleShape)
                            .padding(horizontal = 16.dp),
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
                        viewModel.sendMessage(message.text)
                        message = TextFieldValue()
                    }
            )
        }
    }
}