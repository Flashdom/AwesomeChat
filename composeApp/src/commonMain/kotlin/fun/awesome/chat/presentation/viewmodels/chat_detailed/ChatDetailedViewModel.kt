package `fun`.awesome.chat.presentation.viewmodels.chat_detailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `fun`.awesome.chat.domain.repositories.ChatDetailedRepository
import `fun`.awesome.chat.domain.models.Message
import `fun`.awesome.chat.presentation.State
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatDetailedViewModel(private val chatDetailedRepository: ChatDetailedRepository): ViewModel() {

    private val _messagesState: MutableStateFlow<State<List<Message>>> = MutableStateFlow(State.Loading)
    val messagesState: StateFlow<State<List<Message>>>
        get() = _messagesState

    private val ceh = CoroutineExceptionHandler { _, throwable ->
        Napier.d("Fetching chats error", throwable)
        _messagesState.value = State.Error(throwable)
    }

    init {
        viewModelScope.launch(Dispatchers.Default + ceh) {
            _messagesState.emit(State.Success(chatDetailedRepository.getAllMessagesByChatId(0L)))
        }
    }


    fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnMessageSent -> {
                viewModelScope.launch(Dispatchers.Default + ceh) {
                    chatDetailedRepository.sendMessage(0L, event.text)
                }
            }
        }
    }


    sealed interface Event {
        class OnMessageSent(val text: String): Event
    }
}
