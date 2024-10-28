package `fun`.awesome.chat.presentation.ui.chat_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.add
import awesomechat.composeapp.generated.resources.chat_list_main_hint
import awesomechat.composeapp.generated.resources.chat_list_secondary_hint
import awesomechat.composeapp.generated.resources.chat_list_start_button_text
import awesomechat.composeapp.generated.resources.robot
import `fun`.awesome.chat.presentation.design_system.IconPosition
import `fun`.awesome.chat.presentation.design_system.PrimaryButton
import `fun`.awesome.chat.presentation.design_system.PrimaryText
import `fun`.awesome.chat.presentation.design_system.SecondaryText
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun ChatEmptyListView() {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(Res.drawable.robot), contentDescription = null)
        PrimaryText(text = stringResource(Res.string.chat_list_main_hint), modifier = Modifier.padding(top = 24.dp))
        SecondaryText(stringResource(Res.string.chat_list_secondary_hint), modifier = Modifier.padding(top = 12.dp))
        PrimaryButton(modifier = Modifier.padding(top = 32.dp), text = stringResource(Res.string.chat_list_start_button_text), onClick = {

        }, iconPosition = IconPosition.End(Res.drawable.add))
    }
}
