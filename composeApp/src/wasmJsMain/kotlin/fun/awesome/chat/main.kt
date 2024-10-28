package `fun`.awesome.chat

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import `fun`.awesome.chat.data.PlatformConfiguration
import `fun`.awesome.chat.data.startDI
import `fun`.awesome.chat.presentation.ui.App
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        startDI(platformConfiguration = PlatformConfiguration())
        App()
    }
}
