package `fun`.awesome.chat.presentation.ui.chat_detailed

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.chat_list_main_hint
import awesomechat.composeapp.generated.resources.chat_list_secondary_hint
import awesomechat.composeapp.generated.resources.robot
import `fun`.awesome.chat.presentation.design_system.MessageInputView
import `fun`.awesome.chat.presentation.design_system.PrimaryText
import `fun`.awesome.chat.presentation.design_system.SecondaryText
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun EmptyChatDetailedView() {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.wrapContentSize().weight(10f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(Res.drawable.robot), contentDescription = null)
            PrimaryText(text = stringResource(Res.string.chat_list_main_hint), modifier = Modifier.padding(top = 24.dp))
            SecondaryText(stringResource(Res.string.chat_list_secondary_hint), modifier = Modifier.padding(top = 12.dp))
        }
        Column(modifier = Modifier.wrapContentSize()) {
            MessageInputView(onSendClick = {

            })
        }
    }
}
