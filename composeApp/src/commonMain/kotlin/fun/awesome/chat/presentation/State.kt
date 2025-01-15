package `fun`.awesome.chat.presentation


sealed class State<out T>: ChatListState<T>, ChatDetailedState<T> {

    data class Success<out T>(val data: T): State<T>()

    data class Error(val throwable: Throwable): State<Nothing>()

    data object Loading: State<Nothing>()
}

sealed interface ChatListState<out T> {
    data object EmptyChats: ChatListState<Nothing>
}

sealed interface ChatDetailedState<out T> {
    data object EmptyChat: ChatDetailedState<Nothing>

}



