package `fun`.awesome.chat.presentation.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkBackground = Color(0xFF0A0A0A)
val DefaultButtonColor = Color(192, 247, 166, 0xFF)
val SecondaryButtonColor = Color(57, 59, 63, 0xFF)
val PrimaryTextColor = Color(red = 10, green = 10, blue = 10, alpha = 0xFF)
val LightGrayColor = Color(red = 167, green = 172, blue = 183, alpha = 0xFF)
val MainTextColor = Color(red = 250, green = 250, blue = 250, alpha = 0xFF)
val TertiaryText = Color(red = 192, green = 247, blue = 166, alpha = 0xFF)

val LightsColors = lightColorScheme(
    background = DarkBackground,
    primary = DefaultButtonColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryButtonColor,
    onSecondary = LightGrayColor,
    onSurface = MainTextColor,
    tertiary = TertiaryText
)

val DarkColors = darkColorScheme(
    background = DarkBackground,
    primary = DefaultButtonColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryButtonColor,
    onSecondary = LightGrayColor,
    onSurface = MainTextColor,
    tertiary = TertiaryText
)