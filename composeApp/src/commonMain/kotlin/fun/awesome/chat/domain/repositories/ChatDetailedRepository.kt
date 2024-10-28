package `fun`.awesome.chat.domain.repositories

import `fun`.awesome.chat.domain.models.Message

interface ChatDetailedRepository {

    suspend fun sendMessage(chatId: Long, text: String)

    suspend fun getAllMessagesByChatId(chatId: Long): List<Message>

    suspend fun deleteMessageById(chatId: Long, messageId: Long)
}
