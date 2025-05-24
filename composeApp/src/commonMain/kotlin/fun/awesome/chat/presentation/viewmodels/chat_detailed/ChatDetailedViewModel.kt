package `fun`.awesome.chat.presentation.viewmodels.chat_detailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `fun`.awesome.chat.domain.models.Message
import `fun`.awesome.chat.domain.repositories.ChatDetailedRepository
import `fun`.awesome.chat.presentation.ChatDetailedState
import `fun`.awesome.chat.presentation.State
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatDetailedViewModel(private val chatDetailedRepository: ChatDetailedRepository) :
    ViewModel() {

    private val _messagesState: MutableStateFlow<ChatDetailedState<List<Message>>> =
        MutableStateFlow(State.Loading)
    val messagesState: StateFlow<ChatDetailedState<List<Message>>>
        get() = _messagesState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Napier.d("Fetching chats error", throwable)
        _messagesState.value = State.Error(throwable)
    }

    init {
        viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
           updateMessages()
        }
    }

    private suspend fun updateMessages() {
        val messages = chatDetailedRepository.getAllMessagesByChatId(0L)
        val messageState = if (messages.isNotEmpty()) {
            State.Success(messages)
        } else {
            ChatDetailedState.EmptyChat
        }
        _messagesState.emit(messageState)
    }


    fun obtainEvent(event: Event) {
        when (event) {
            is Event.SendMessage -> {
                viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
                    val messages = chatDetailedRepository.getAllMessagesByChatId(event.chatId)
                    val (newMessage, newReply) = chatDetailedRepository.sendMessage(
                        event.chatId,
                        event.text
                    )
                    _messagesState.emit(State.Success(messages + newMessage + newReply))
                }
            }

            is Event.DeleteMessage -> {
                viewModelScope.launch(Dispatchers.Default + coroutineExceptionHandler) {
                    chatDetailedRepository.deleteMessageById(event.chatId, event.messageId)
                    updateMessages()
                }
            }
        }
    }


    sealed interface Event {
        class SendMessage(val chatId: Long, val text: String) : Event

        class DeleteMessage(val chatId: Long, val messageId: Long) : Event
    }
}
