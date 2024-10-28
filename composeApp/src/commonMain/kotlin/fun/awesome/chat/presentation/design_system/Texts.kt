package `fun`.awesome.chat.presentation.design_system

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import awesomechat.composeapp.generated.resources.BricolageGrotesque_24pt_SemiBold
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.SFPRODISPLAYMEDIUM
import awesomechat.composeapp.generated.resources.SFPRODISPLAYREGULAR
import org.jetbrains.compose.resources.Font


@Composable
fun PrimaryText(text: String, modifier: Modifier = Modifier, fontSize: Int= 24, lineHeight: Int = 28) {
    Text(
        color = Color(red = 250, green = 250, blue = 250, alpha = 0xFF),
        text = text,
        fontSize = fontSize.sp,
        lineHeight = lineHeight.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.then(modifier),
        overflow = TextOverflow.Ellipsis,
        fontFamily = FontFamily(Font(resource = Res.font.BricolageGrotesque_24pt_SemiBold))
    )
}

@Composable
fun SecondaryText(text: String, modifier: Modifier = Modifier) {
    Text(
        color = Color(red = 167, green = 172, blue = 183, alpha = 0xFF),
        text = text,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.then(modifier),
        overflow = TextOverflow.Ellipsis,
        fontFamily = FontFamily(Font(resource = Res.font.SFPRODISPLAYMEDIUM))
    )
}

@Composable
fun TertiaryText(text: String, modifier: Modifier = Modifier) {
    Text(
        color = Color(red = 192, green = 247, blue = 166, alpha = 0xFF),
        text = text,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.then(modifier),
        overflow = TextOverflow.Ellipsis,
        fontFamily = FontFamily(Font(resource = Res.font.SFPRODISPLAYREGULAR))
    )
}

