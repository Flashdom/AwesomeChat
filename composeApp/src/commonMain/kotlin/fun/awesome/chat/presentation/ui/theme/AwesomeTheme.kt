package `fun`.awesome.chat.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AwesomeChatTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightsColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = getTypography(),
        shapes = AppShapes,
        content = content
    )
}