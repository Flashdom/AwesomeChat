package `fun`.awesome.chat.data.chat_detailed.dto

import kotlinx.serialization.Serializable

@Serializable
class MessageWrapperDto(val message: MessageDto, val reply: MessageDto)

class MessagesWrapperDto(val messages: List<MessageDto>)

@Serializable
class SendMessageRequestBody(val text: String)

@Serializable
data class MessageDto(val id: Long, val chatId: Long, val authorRole: String, val text: String, val createdAt: String)
