package `fun`.awesome.chat

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import `fun`.awesome.chat.data.PlatformConfiguration
import `fun`.awesome.chat.data.startDI
import `fun`.awesome.chat.presentation.ui.App
import kotlinx.browser.document
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class,
    ExperimentalMaterial3WindowSizeClassApi::class
)
fun main() {
    ComposeViewport(document.body!!) {
        startDI(platformConfiguration = PlatformConfiguration())
        App(onNavHostReady = {
            window.bindToNavigation(it)
        },
            windowSizeClass = calculateWindowSizeClass()
        )
    }
}
