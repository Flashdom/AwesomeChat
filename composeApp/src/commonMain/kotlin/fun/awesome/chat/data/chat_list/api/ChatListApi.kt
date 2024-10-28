package `fun`.awesome.chat.data.chat_list.api

import `fun`.awesome.chat.data.chat_list.dto.ChatDto
import `fun`.awesome.chat.data.chat_list.dto.ChatWrapperDto

interface ChatListApi {

    suspend fun fetchAllChats(): ChatWrapperDto

    suspend fun createChat() : ChatDto

    suspend fun deleteChat(chatId: Long)
}
