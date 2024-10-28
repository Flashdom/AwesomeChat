package `fun`.awesome.chat.presentation.ui.chat_detailed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import `fun`.awesome.chat.domain.models.Message
import `fun`.awesome.chat.presentation.viewmodels.chat_detailed.ChatDetailedViewModel
import `fun`.awesome.chat.presentation.State
import `fun`.awesome.chat.presentation.ui.ErrorView
import `fun`.awesome.chat.presentation.ui.LoadingView
import org.koin.compose.koinInject


@Composable
fun ChatDetailedScreen(chatDetailedViewModel: ChatDetailedViewModel = koinInject()) {
    val state by chatDetailedViewModel.messagesState.collectAsStateWithLifecycle()
    when (val uiState = state) {
        is State.Error -> ErrorView()
        State.Loading -> LoadingView()
        is State.Success<List<Message>> -> ChatDetailedView(uiState.data)
    }
}
