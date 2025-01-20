package `fun`.awesome.chat.presentation.ui.chat_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.SFPRODISPLAYMEDIUM
import awesomechat.composeapp.generated.resources.SFPRODISPLAYREGULAR
import awesomechat.composeapp.generated.resources.chat_list_new_chat_text
import `fun`.awesome.chat.domain.models.Chat
import `fun`.awesome.chat.presentation.design_system.PrimaryButton
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource

@Composable
fun ChatListView(chats: List<Chat>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(chats) { chat ->
                Card {
                    Text(
                        color = Color(red = 192, green = 247, blue = 166, alpha = 0xFF),
                        text = chat.title,
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(resource = Res.font.SFPRODISPLAYMEDIUM))
                    )

                    Text(
                        color = Color(red = 167, green = 172, blue = 183, alpha = 0xFF),
                        text = chat.lastMessage,
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(resource = Res.font.SFPRODISPLAYREGULAR))
                    )
                    Text(
                        color = Color(red = 122, green = 128, blue = 140, alpha = 0xFF),
                        text = chat.lastMessage,
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(resource = Res.font.SFPRODISPLAYREGULAR))
                    )
                }
            }
        }
        PrimaryButton(text = stringResource(Res.string.chat_list_new_chat_text), onClick = {

        })
    }
}
