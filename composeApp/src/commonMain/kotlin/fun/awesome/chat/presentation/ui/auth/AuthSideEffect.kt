package `fun`.awesome.chat.presentation.ui.auth

sealed class AuthSideEffect {
    class ShowSnackbar(val message: String) : AuthSideEffect()
}