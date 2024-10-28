package `fun`.awesome.chat.data.chat_list.dto

import `fun`.awesome.chat.data.chat_detailed.dto.MessageDto
import kotlinx.serialization.Serializable

@Serializable
class ChatWrapperDto(val chats: List<ChatDto>)

@Serializable
data class ChatDto
(
    val id: Long,
    val title: String,
    val createdAt: String,
    val latestMessages: List<MessageDto>
)

