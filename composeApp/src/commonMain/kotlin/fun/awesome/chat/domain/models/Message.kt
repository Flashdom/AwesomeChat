package `fun`.awesome.chat.domain.models


data class Message(val id: Long, val text: String, val isSent: SendingStatus)

enum class SendingStatus {
    SENDING,
    SENT,
    FAILED
}
