package `fun`.awesome.chat

import androidx.compose.ui.window.ComposeUIViewController
import `fun`.awesome.chat.data.PlatformConfiguration
import `fun`.awesome.chat.data.startDI
import `fun`.awesome.chat.presentation.ui.App

fun MainViewController() = ComposeUIViewController {
    startDI(platformConfiguration = PlatformConfiguration())
    App()
}
