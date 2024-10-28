package `fun`.awesome.chat.presentation.viewmodels.auth

import androidx.lifecycle.ViewModel
import `fun`.awesome.chat.domain.repositories.AuthRepository
import `fun`.awesome.chat.presentation.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _loginState: MutableStateFlow<State<Unit>> = MutableStateFlow(State.Loading)
    val loginState: StateFlow<State<Unit>>
        get() = _loginState

    fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoginClicked -> {
            }
        }
    }

    sealed interface Event {
        class OnLoginClicked : Event
    }
}
