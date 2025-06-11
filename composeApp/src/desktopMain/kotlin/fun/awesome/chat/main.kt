package `fun`.awesome.chat

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import `fun`.awesome.chat.data.PlatformConfiguration
import `fun`.awesome.chat.data.startDI
import `fun`.awesome.chat.presentation.ui.App

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AwesomeChat",
    ) {
        startDI(platformConfiguration = PlatformConfiguration())
        App(windowSizeClass = calculateWindowSizeClass())
    }
}
