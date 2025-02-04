package `fun`.awesome.chat.data

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import `fun`.awesome.chat.presentation.ui.auth.AuthView
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.okhttp.OkHttp
import java.util.prefs.Preferences

actual fun httpClient(config: HttpClientConfig<out HttpClientEngineConfig>.() -> Unit): HttpClient {
    return HttpClient(OkHttp) {
        config(this)
        engine {
            config {
                followRedirects(true)
            }
        }
    }
}

actual fun settings(platformConfiguration: PlatformConfiguration): Settings {
    return PreferencesSettings(Preferences.userRoot())
}

actual class PlatformConfiguration

@Preview
@Composable
fun AuthPreview() {
    AuthView({})
}
