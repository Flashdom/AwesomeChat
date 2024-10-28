package `fun`.awesome.chat.data.chat_list.api

import `fun`.awesome.chat.data.chat_list.dto.ChatDto
import `fun`.awesome.chat.data.chat_list.dto.ChatWrapperDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ChatListApiImpl(private val client: HttpClient): ChatListApi {

    override suspend fun fetchAllChats(): ChatWrapperDto {
        return client.get("Chats") {}.body()
    }

    override suspend fun createChat(): ChatDto {
        return client.post("Chats") {}.body()
    }

    override suspend fun deleteChat(chatId: Long) {
        client.delete("Chats/$chatId")
    }
}
