package `fun`.awesome.chat.presentation.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import `fun`.awesome.chat.presentation.viewmodels.auth.AuthViewModel
import `fun`.awesome.chat.presentation.State
import `fun`.awesome.chat.presentation.ui.ErrorView
import `fun`.awesome.chat.presentation.ui.LoadingView
import `fun`.awesome.chat.presentation.ui.chat_detailed.EmptyChatDetailedView
import `fun`.awesome.chat.presentation.ui.chat_list.ChatEmptyListView
import org.koin.compose.koinInject

@Composable
fun AuthScreen(viewModel: AuthViewModel = koinInject()) {

    val state by viewModel.loginState.collectAsStateWithLifecycle()

    when (val uiState = state) {
        is State.Error -> {
            ErrorView()
        }

        State.Loading ->  {
            EmptyChatDetailedView()
        }
        is State.Success ->  {
            AuthView()
        }
    }

}
