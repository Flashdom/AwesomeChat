package `fun`.awesome.chat.domain.models


data class Message(val id: Long, val text: String, val isSent: SendingStatus, val author: Author)

enum class SendingStatus {
    SENDING,
    SENT,
    FAILED
}

enum class Author {
    AI,
    USER
}
