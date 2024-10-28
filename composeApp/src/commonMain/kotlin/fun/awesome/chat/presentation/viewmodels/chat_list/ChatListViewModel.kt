package `fun`.awesome.chat.presentation.viewmodels.chat_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `fun`.awesome.chat.domain.repositories.ChatListRepository
import `fun`.awesome.chat.domain.models.Chat
import `fun`.awesome.chat.presentation.ChatState
import `fun`.awesome.chat.presentation.State
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatListViewModel(private val chatListRepository: ChatListRepository): ViewModel() {

    private val _chatListState: MutableStateFlow<ChatState<List<Chat>>> = MutableStateFlow(State.Loading)
    val chatListState: StateFlow<ChatState<List<Chat>>>
        get() = _chatListState

    private val ceh = CoroutineExceptionHandler { _, throwable ->
        Napier.d("Fetching chats error", throwable)
        _chatListState.value = State.Error(throwable)
    }
    init {
        viewModelScope.launch(Dispatchers.Default + ceh) {
            _chatListState.emit(State.Success(chatListRepository.fetchChats()))
        }
    }

    fun obtainEvent(event: Event) {
        when (event) {
            Event.CreateChat -> {
                viewModelScope.launch(Dispatchers.Default + ceh) {
                    val chats = (_chatListState.value as? State.Success)?.data ?: error("Unable to create chat")
                    _chatListState.emit(State.Success(chats + chatListRepository.createChat()))
                }
            }
        }
    }

    sealed interface Event {
        data object CreateChat: Event
    }
}
