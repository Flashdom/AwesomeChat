package `fun`.awesome.chat.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.SFPRODISPLAYREGULAR
import org.jetbrains.compose.resources.Font

@Composable
fun getTypography(): Typography {

    val bodyFontFamily = FontFamily(
        Font(
            Res.font.SFPRODISPLAYREGULAR,
            FontWeight.Normal,
        )
    )
    return Typography(
        bodyLarge = Typography().bodyLarge.copy(
            fontFamily = bodyFontFamily,
            fontSize = 16.sp,
            lineHeight = 20.sp,
        ),
        labelMedium = Typography().labelMedium.copy(
            fontFamily = bodyFontFamily,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = LightGrayColor
        )
    )
}
