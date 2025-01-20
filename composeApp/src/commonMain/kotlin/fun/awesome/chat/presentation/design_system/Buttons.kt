package `fun`.awesome.chat.presentation.design_system

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
    iconPosition: IconPosition = IconPosition.Blank
) {
    TextButton(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp).then(modifier),
        shape = RoundedCornerShape(36.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(192, 247, 166, 0xFF)),
        content = {
            when (iconPosition) {
                IconPosition.Blank -> {
                    Text(
                        text = text,
                        color = Color(red = 10, green = 10, blue = 10, alpha = 0xFF),
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontFamily = FontFamily(
                            Font(Res.font.SFPRODISPLAYREGULAR)
                        ),
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                }

                is IconPosition.End -> {
                    Text(
                        text = text,
                        color = Color(red = 10, green = 10, blue = 10, alpha = 0xFF),
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontFamily = FontFamily(
                            Font(Res.font.SFPRODISPLAYREGULAR)
                        ),
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Icon(modifier = Modifier.size(24.dp).padding(start = 8.dp), painter = painterResource(iconPosition.drawableResource), contentDescription = null)
                }

                is IconPosition.Start -> {
                    Icon(modifier = Modifier.size(24.dp).padding(end = 8.dp), painter = painterResource(iconPosition.drawableResource), contentDescription = null)
                    Text(
                        text = text,
                        color = Color(red = 10, green = 10, blue = 10, alpha = 0xFF),
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontFamily = FontFamily(
                            Font(Res.font.SFPRODISPLAYREGULAR)
                        ),
                        fontSize = 16.sp,
                        lineHeight = 20.sp
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
