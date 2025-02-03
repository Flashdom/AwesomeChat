package `fun`.awesome.chat.presentation.design_system

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.SFPRODISPLAYREGULAR
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource


@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconPosition: IconPosition = IconPosition.Blank,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    TextButton(
        modifier = modifier.wrapContentHeight().padding(horizontal = 16.dp),
        shape = RoundedCornerShape(36.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        content = {
            val textColor = textColor
            when (iconPosition) {
                IconPosition.Blank -> {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge,
                        color = textColor,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                }

                is IconPosition.End -> {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge,
                        color = textColor,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                    Icon(
                        modifier = Modifier.size(24.dp).padding(start = 8.dp),
                        painter = painterResource(iconPosition.drawableResource),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }

                is IconPosition.Start -> {
                    Icon(
                        modifier = Modifier.size(32.dp).padding(start = 8.dp, end = 8.dp),
                        painter = painterResource(iconPosition.drawableResource),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge,
                        color = textColor,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                }
            }
        },
        onClick = {
            onClick()
        })
}

sealed class IconPosition {
    data object Blank : IconPosition()

    data class Start(val drawableResource: DrawableResource) : IconPosition()

    data class End(val drawableResource: DrawableResource) : IconPosition()
}
