package `fun`.awesome.chat.data.auth.api

import io.ktor.client.HttpClient
import org.koin.core.component.KoinComponent

class AuthApiImpl(private val client: HttpClient): AuthApi, KoinComponent {

    override suspend fun login() {
        TODO("Not yet implemented")
    }
}
