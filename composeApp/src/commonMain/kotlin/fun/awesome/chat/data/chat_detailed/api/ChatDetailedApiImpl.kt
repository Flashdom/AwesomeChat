package `fun`.awesome.chat.data.chat_detailed.api

import `fun`.awesome.chat.data.chat_detailed.dto.MessageWrapperDto
import `fun`.awesome.chat.data.chat_detailed.dto.MessagesWrapperDto
import `fun`.awesome.chat.data.chat_detailed.dto.SendMessageRequestBody
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ChatDetailedApiImpl(private val client: HttpClient): ChatDetailedApi {
    override suspend fun fetchMessagesByChatId(id: Long): MessagesWrapperDto {
       return client.get("Chats/${id}/Messages") {}.body()
    }

    override suspend fun sendMessage(chatId: Long, text: String): MessageWrapperDto {
       return client.post("Chats/${chatId}/Messages") {
            setBody(SendMessageRequestBody(text))
        }.body()
    }

    override suspend fun deleteMessageById(chatId: Long, messageId: Long) {
        client.delete("Chats/${chatId}/Messages/${messageId}")
    }

}
