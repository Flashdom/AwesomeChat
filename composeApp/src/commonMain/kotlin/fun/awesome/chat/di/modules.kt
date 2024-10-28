package `fun`.awesome.chat.di

import `fun`.awesome.chat.data.auth.AuthRepositoryImpl
import `fun`.awesome.chat.data.auth.api.AuthApi
import `fun`.awesome.chat.data.auth.api.AuthApiImpl
import `fun`.awesome.chat.data.auth.storage.Storage
import `fun`.awesome.chat.data.auth.storage.StorageImpl
import `fun`.awesome.chat.data.chat_detailed.ChatDetailedRepositoryImpl
import `fun`.awesome.chat.data.chat_detailed.api.ChatDetailedApi
import `fun`.awesome.chat.data.chat_detailed.api.ChatDetailedApiImpl
import `fun`.awesome.chat.data.chat_list.ChatListRepositoryImpl
import `fun`.awesome.chat.data.chat_list.api.ChatListApi
import `fun`.awesome.chat.data.chat_list.api.ChatListApiImpl
import `fun`.awesome.chat.data.httpClient
import `fun`.awesome.chat.data.settings
import `fun`.awesome.chat.domain.repositories.AuthRepository
import `fun`.awesome.chat.domain.repositories.ChatDetailedRepository
import `fun`.awesome.chat.domain.repositories.ChatListRepository
import `fun`.awesome.chat.presentation.viewmodels.auth.AuthViewModel
import `fun`.awesome.chat.presentation.viewmodels.chat_detailed.ChatDetailedViewModel
import `fun`.awesome.chat.presentation.viewmodels.chat_list.ChatListViewModel
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<ChatDetailedRepository> {
        ChatDetailedRepositoryImpl(get())
    }
    single<ChatListRepository> {
        ChatListRepositoryImpl(get())
    }
}

val presentationModule = module {
    viewModelOf(::AuthViewModel)
    viewModelOf(::ChatListViewModel)
    viewModelOf(::ChatDetailedViewModel)
}

val apiModule = module {
    factory<AuthApi> {
        AuthApiImpl(client = get(named("auth")))
    }

    single<Storage> {
        StorageImpl(settings = get())
    }

    single {
        settings(platformConfiguration = get())
    }

    factory<AuthRepository> {
        AuthRepositoryImpl(authApi = get(), storage = get())
    }

    factory<HttpClient>(named("auth")) {
        httpClient {
            install(DefaultRequest) {
                url("https://www.awesomechat.fun/api/v1")
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v("HTTP Client", null, message)
                    }

                }.also {
                    Napier.base(DebugAntilog())
                }
                level = LogLevel.HEADERS
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    single<HttpClient>(named("chat")) {
        httpClient {
            install(DefaultRequest) {
                url("https://www.awesomechat.fun/api/v1")
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v("HTTP Client", null, message)
                    }

                }.also {
                    Napier.base(DebugAntilog())
                }
                level = LogLevel.HEADERS
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    single<ChatDetailedApi> {
        ChatDetailedApiImpl(get(named("chat")))
    }

    single<ChatListApi> {
        ChatListApiImpl(get(named("chat")))
    }
}
