package `fun`.awesome.chat.presentation.viewmodels.chat_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `fun`.awesome.chat.domain.models.Chat
import `fun`.awesome.chat.domain.repositories.ChatListRepository
import `fun`.awesome.chat.presentation.ChatListState
import `fun`.awesome.chat.presentation.State
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatListViewModel(private val chatListRepository: ChatListRepository) : ViewModel() {

    private val _chatListState: MutableStateFlow<ChatListState<List<Chat>>> =
        MutableStateFlow(State.Loading)
    val chatListState: StateFlow<ChatListState<List<Chat>>>
        get() = _chatListState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Napier.d("Fetching chats error", throwable)
        _chatListState.value = State.Error(throwable)
    }

    init {
        viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
            updateChats()
        }
    }

    private suspend fun updateChats() {
        val chats = chatListRepository.fetchChats()
        if (chats.isNotEmpty()) {
            _chatListState.emit(State.Success(chats))
        } else {
            _chatListState.emit(ChatListState.EmptyChats)
        }
    }

    fun obtainEvent(event: Event) {
        when (event) {
            Event.CreateChat -> {
                viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
                    chatListRepository.createChat()
                    updateChats()
                }
            }

            is Event.DeleteChatById -> viewModelScope.launch {
                chatListRepository.deleteChatById(event.chatId)
                updateChats()
            }
        }
    }

    sealed interface Event {

        data object CreateChat : Event

        data class DeleteChatById(val chatId: Long) : Event

    }
}
