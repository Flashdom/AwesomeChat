package `fun`.awesome.chat

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import `fun`.awesome.chat.data.PlatformConfiguration
import `fun`.awesome.chat.data.startDI
import `fun`.awesome.chat.presentation.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AwesomeChat",
    ) {
        startDI(platformConfiguration = PlatformConfiguration())
        App()
    }
}
