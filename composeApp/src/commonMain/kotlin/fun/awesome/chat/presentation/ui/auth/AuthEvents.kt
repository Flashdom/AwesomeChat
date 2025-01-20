package `fun`.awesome.chat.presentation.ui.auth

sealed class AuthEvent {
    data class LoginButtonClicked(val login: String, val password: String) : AuthEvent()
    data object ForgotPasswordClicked : AuthEvent()
    data object GoogleAuthClicked : AuthEvent()
    data object FacebookAuthClicked : AuthEvent()
}