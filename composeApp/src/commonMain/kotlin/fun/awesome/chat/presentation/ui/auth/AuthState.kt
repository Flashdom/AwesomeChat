package `fun`.awesome.chat.presentation.ui.auth

sealed class AuthState{
    data object CheckingAuth : AuthState()
    data object LoggingForm : AuthState()
    data object Loading : AuthState()
    data class SuccessLogging (val result: Any) : AuthState()
    data class ErrorLogging(val throwable: Throwable) : AuthState()
}