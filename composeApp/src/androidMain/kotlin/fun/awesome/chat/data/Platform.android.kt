package `fun`.awesome.chat.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import `fun`.awesome.chat.presentation.ui.auth.AuthView
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.okhttp.OkHttp


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
  return SharedPreferencesSettings.Factory(platformConfiguration.context).create("Settings")
}

actual class PlatformConfiguration(
    val context: Context
)

@Preview
@Composable
fun AuthPreview() {
    AuthView {}
}