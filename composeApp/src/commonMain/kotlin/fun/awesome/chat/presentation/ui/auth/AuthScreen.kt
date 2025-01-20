package `fun`.awesome.chat.presentation.ui.auth

import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import `fun`.awesome.chat.presentation.viewmodels.auth.AuthViewModel
import `fun`.awesome.chat.presentation.ui.ErrorView
import `fun`.awesome.chat.presentation.ui.LoadingView
import `fun`.awesome.chat.presentation.ui.chat_detailed.EmptyChatDetailedView
import `fun`.awesome.chat.presentation.ui.showSnackbar
import org.koin.compose.koinInject

@Composable
fun AuthScreen(viewModel: AuthViewModel = koinInject()) {

    val state by viewModel.loginState.collectAsStateWithLifecycle()
    val sideEffects = viewModel.sideEffects
    val snackbarHostState = remember { SnackbarHostState() }

    when (state) {
        AuthState.CheckingAuth -> TODO()
        is AuthState.ErrorLogging -> ErrorView()
        AuthState.Loading -> LoadingView()
        AuthState.LoggingForm -> AuthView(onEvent = { event -> viewModel.obtainEvent(event) })
        is AuthState.SuccessLogging -> EmptyChatDetailedView{}
    }

    LaunchedEffect(Unit) {
        sideEffects.collect { sideEffect ->
            when (sideEffect) {
                is AuthSideEffect.ShowSnackbar -> {
                    showSnackbar(snackbarHostState = snackbarHostState, message = sideEffect.message, )
                }
                else -> Unit
            }
        }
    }
    // TODO : Make custom snackbar
    SnackbarHost(hostState = snackbarHostState)
}
