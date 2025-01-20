package `fun`.awesome.chat.presentation.ui.auth

sealed class AuthState <out T> {
    data object CheckingAuth : AuthState<Nothing>()
    data object LoggingForm : AuthState<Nothing>()
    data object Loading : AuthState<Nothing>()
    data class SuccessLogging<out T> (val result: T) : AuthState<T>()
    data class ErrorLogging(val throwable: Throwable) : AuthState<Nothing>()
}