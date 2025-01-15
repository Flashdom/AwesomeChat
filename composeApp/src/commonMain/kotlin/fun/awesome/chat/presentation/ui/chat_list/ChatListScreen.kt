

package `fun`.awesome.chat.presentation.ui.chat_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import `fun`.awesome.chat.domain.models.Chat
import `fun`.awesome.chat.presentation.ChatListState
import `fun`.awesome.chat.presentation.State
import `fun`.awesome.chat.presentation.ui.ErrorView
import `fun`.awesome.chat.presentation.ui.LoadingView
import `fun`.awesome.chat.presentation.viewmodels.chat_list.ChatListViewModel
import org.koin.compose.koinInject


@Composable
fun ChatListScreen(chatListViewModel: ChatListViewModel = koinInject()) {

    val state by chatListViewModel.chatListState.collectAsStateWithLifecycle()

    when (val uiState = state) {
        is State.Error -> {
            ErrorView()
        }

        is State.Loading -> {
            LoadingView()
        }

        is State.Success<List<Chat>> ->  {
            ChatListView(uiState.data)
        }

        ChatListState.EmptyChats ->  {
            ChatEmptyListView()
        }
    }

}

