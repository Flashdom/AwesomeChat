package `fun`.awesome.chat.data

import com.russhwolf.settings.Settings
import `fun`.awesome.chat.di.apiModule
import `fun`.awesome.chat.di.dataModule
import `fun`.awesome.chat.di.presentationModule
import io.ktor.client.*
import io.ktor.client.engine.HttpClientEngineConfig
import org.koin.core.context.startKoin
import org.koin.dsl.module

expect class PlatformConfiguration

fun startDI(platformConfiguration: PlatformConfiguration) {
    val platformModule = module {
        single { platformConfiguration }
    }
    startKoin {
        modules(apiModule, dataModule, platformModule, presentationModule)
    }
}

expect fun httpClient(config: HttpClientConfig<out HttpClientEngineConfig>.() -> Unit): HttpClient

expect fun settings(platformConfiguration: PlatformConfiguration): Settings
