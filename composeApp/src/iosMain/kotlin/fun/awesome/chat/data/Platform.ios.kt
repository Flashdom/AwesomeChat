package `fun`.awesome.chat.data

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.darwin.Darwin
import platform.Foundation.NSUserDefaults

actual fun httpClient(config: HttpClientConfig<out HttpClientEngineConfig>.() -> Unit): HttpClient {
    return HttpClient(Darwin) {
        config(this)
    }
}

actual fun settings(platformConfiguration: PlatformConfiguration): Settings {
    return NSUserDefaultsSettings(NSUserDefaults())
}

actual class PlatformConfiguration
