package `fun`.awesome.chat.presentation.design_system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.chat_detailed_input_placeholder
import org.jetbrains.compose.resources.stringResource


@Composable
fun MessageInputView(modifier: Modifier = Modifier, onSendClick: (String) -> Unit) {
    var textState by remember { mutableStateOf("") }
    OutlinedTextField(
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(
                122,
                128,
                149,
                0x52,
            ), focusedBorderColor = Color(
                122,
                128,
                149,
                0x52,
            ), textColor = Color.White, placeholderColor = Color(122, 128, 140, 0xFF)
        ),
        trailingIcon = {
            IconButton(onClick = {
                onSendClick(textState)
            }) {
                Icon(
                    Icons.AutoMirrored.Outlined.Send,
                    contentDescription = null,
                    modifier = Modifier.clip(
                        RoundedCornerShape(16.dp)
                    ).background(Color(192, 247, 166, 0xFF)).size(48.dp).padding(8.dp),
                    tint = Color.Black
                )

            }
        },
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp)
            .then(modifier),
        value = textState,
        onValueChange = {
            textState = it
        },
        placeholder = {
            Text(text = stringResource(Res.string.chat_detailed_input_placeholder))
        })

}
