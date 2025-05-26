package `fun`.awesome.chat.domain.repositories

import `fun`.awesome.chat.domain.models.Chat

interface ChatListRepository {

    suspend fun createChat()

    suspend fun fetchChats(): List<Chat>

    suspend fun deleteChatById(chatId: Long)

}
