package `fun`.awesome.chat.data

import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.js.JsClient

actual fun httpClient(config: HttpClientConfig<out HttpClientEngineConfig>.() -> Unit): HttpClient  {
    return HttpClient(JsClient()) {
        config(this)
    }
}

actual fun settings(platformConfiguration: PlatformConfiguration): Settings {
    return StorageSettings()
}

actual class PlatformConfiguration
