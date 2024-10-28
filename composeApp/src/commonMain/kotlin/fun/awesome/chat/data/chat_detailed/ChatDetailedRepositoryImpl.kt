package `fun`.awesome.chat.data.chat_detailed

import `fun`.awesome.chat.data.chat_detailed.api.ChatDetailedApi
import `fun`.awesome.chat.data.chat_detailed.dto.MessageDto
import `fun`.awesome.chat.domain.repositories.ChatDetailedRepository
import `fun`.awesome.chat.domain.models.Message
import `fun`.awesome.chat.domain.models.SendingStatus


class ChatDetailedRepositoryImpl(private val chatDetailedApi: ChatDetailedApi):
    ChatDetailedRepository {
    override suspend fun sendMessage(chatId: Long, text: String) {
        chatDetailedApi.sendMessage(chatId, text)
    }

    override suspend fun getAllMessagesByChatId(chatId: Long): List<Message> {
        return chatDetailedApi.fetchMessagesByChatId(chatId).messages.map {
            it.mapToMessage()
        }
    }

    override suspend fun deleteMessageById(chatId: Long, messageId: Long) {
        chatDetailedApi.deleteMessageById(chatId, messageId)
    }
}

fun MessageDto.mapToMessage(): Message {
    return Message(id, text, isSent = SendingStatus.SENT)
}
