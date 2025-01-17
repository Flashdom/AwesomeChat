package `fun`.awesome.chat.presentation.viewmodels.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `fun`.awesome.chat.domain.repositories.AuthRepository
import `fun`.awesome.chat.presentation.ui.auth.AuthEvent
import `fun`.awesome.chat.presentation.ui.auth.AuthSideEffect
import `fun`.awesome.chat.presentation.ui.auth.AuthState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _loginState: MutableStateFlow<AuthState<Any>> =
        MutableStateFlow(AuthState.LoggingForm)
    val loginState: StateFlow<AuthState<Any>>
        get() = _loginState

    private val _sideEffects = MutableSharedFlow<AuthSideEffect>()
    val sideEffects: SharedFlow<AuthSideEffect>
        get() = _sideEffects

    fun obtainEvent(event: AuthEvent) {
        when (event) {
            AuthEvent.FacebookAuthClicked -> TODO()
            AuthEvent.ForgotPasswordClicked -> TODO()
            AuthEvent.GoogleAuthClicked -> TODO()
            is AuthEvent.LoginButtonClicked -> loginByCredentialStub(event.login, event.password)
        }
    }

    // TODO make dataclass for credential
    private fun loginByCredentialStub(user: String, password: String) {
        if (user.isBlank() and password.isBlank()) {
            _loginState.value = AuthState.SuccessLogging("Any data")
        } else {
            emitSideEffect(AuthSideEffect.ShowSnackbar("incorrect login or password"))
        }
    }

    private fun emitSideEffect(sideEffect: AuthSideEffect) {
        viewModelScope.launch {
            _sideEffects.emit(sideEffect)
        }
    }
}
