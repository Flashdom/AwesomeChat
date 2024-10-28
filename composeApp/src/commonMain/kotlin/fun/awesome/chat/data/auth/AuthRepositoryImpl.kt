package `fun`.awesome.chat.data.auth

import `fun`.awesome.chat.data.auth.api.AuthApi
import `fun`.awesome.chat.data.auth.storage.Storage
import `fun`.awesome.chat.domain.repositories.AuthRepository

class AuthRepositoryImpl(private val authApi: AuthApi, private val storage: Storage): AuthRepository {
    override suspend fun login() {
        authApi.login()
    }
}
