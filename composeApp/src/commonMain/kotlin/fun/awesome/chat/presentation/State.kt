package `fun`.awesome.chat.presentation


sealed class State<out T>: ChatState<T> {

    data class Success<out T>(val data: T): State<T>()

    data class Error(val throwable: Throwable): State<Nothing>()

    data object Loading: State<Nothing>()
}

sealed interface ChatState<out T> {
    data object EmptyChats: ChatState<Nothing>
}

