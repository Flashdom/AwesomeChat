package `fun`.awesome.chat.presentation.ui.chat_detailed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import `fun`.awesome.chat.domain.models.Author.AI
import `fun`.awesome.chat.domain.models.Author.USER
import `fun`.awesome.chat.domain.models.Message
import `fun`.awesome.chat.presentation.design_system.MessageInputView


@Composable
fun ChatDetailedView(messages: List<Message>, onMessageSent: (String) -> Unit) {
    Column {
        LazyColumn {
            items(messages) { message ->
                when (message.author) {
                    AI -> Row(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = message.text)
                    }

                    USER -> Row(
                        modifier = Modifier.fillParentMaxWidth().wrapContentHeight(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(text = message.text)
                    }
                }
            }
        }
        MessageInputView {
            onMessageSent(it)
        }
    }
}
