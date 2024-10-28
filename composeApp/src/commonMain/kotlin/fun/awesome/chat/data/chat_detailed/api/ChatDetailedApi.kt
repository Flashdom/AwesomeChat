package `fun`.awesome.chat.data.chat_detailed.api

import `fun`.awesome.chat.data.chat_detailed.dto.MessageWrapperDto
import `fun`.awesome.chat.data.chat_detailed.dto.MessagesWrapperDto

interface ChatDetailedApi {

    suspend fun fetchMessagesByChatId(id: Long): MessagesWrapperDto

    suspend fun sendMessage(chatId: Long, text: String): MessageWrapperDto

    suspend fun deleteMessageById(chatId: Long, messageId: Long)
}
