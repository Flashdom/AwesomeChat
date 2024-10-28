package `fun`.awesome.chat.data.auth.storage

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set


class StorageImpl(private val settings: Settings): Storage {

    companion object {
        const val ACCESS_TOKEN_KEY = "access_token"
        const val REFRESH_TOKEN_KEY = "refresh_token"
    }


    override fun saveAccessToken(accessToken: String) {
        settings[ACCESS_TOKEN_KEY] = accessToken
    }

    override fun saveRefreshToken(refreshToken: String) {
        settings[REFRESH_TOKEN_KEY] = refreshToken
    }

    override fun getAccessToken(): String {
        return settings[ACCESS_TOKEN_KEY] ?: ""
    }

    override fun getRefreshToken(): String {
        return settings[REFRESH_TOKEN_KEY]?: ""
    }
}
