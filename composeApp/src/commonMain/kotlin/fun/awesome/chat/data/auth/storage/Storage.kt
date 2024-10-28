package `fun`.awesome.chat.data.auth.storage

interface Storage {

    fun saveAccessToken(accessToken: String)

    fun saveRefreshToken(refreshToken: String)

    fun getAccessToken(): String

    fun getRefreshToken(): String
}
