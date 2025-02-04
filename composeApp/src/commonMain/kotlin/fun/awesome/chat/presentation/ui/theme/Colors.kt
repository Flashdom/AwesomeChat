package `fun`.awesome.chat.presentation.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkBackground = Color(0xFF0A0A0A)
val DefaultButtonColor = Color (192, 247, 166, 0xFF)
val SecondaryButtonColor = Color (57, 59, 63, 0xFF)
val PrimaryTextColor = Color(red = 10, green = 10, blue = 10, alpha = 0xFF)
val SecondaryTextColor = Color.White

val LightsColors = lightColorScheme(
    background = DarkBackground,
    primary = DefaultButtonColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryButtonColor,
    onSecondary = SecondaryTextColor
)

val DarkColors = darkColorScheme(
    background = DarkBackground,
    primary = DefaultButtonColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryButtonColor,
    onSecondary = SecondaryTextColor
)