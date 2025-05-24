package `fun`.awesome.chat.data.chat_detailed

import `fun`.awesome.chat.data.chat_detailed.api.ChatDetailedApi
import `fun`.awesome.chat.data.chat_detailed.dto.MessageDto
import `fun`.awesome.chat.domain.models.Author
import `fun`.awesome.chat.domain.models.Message
import `fun`.awesome.chat.domain.models.SendingStatus
import `fun`.awesome.chat.domain.repositories.ChatDetailedRepository


class ChatDetailedRepositoryImpl(private val chatDetailedApi: ChatDetailedApi) :
    ChatDetailedRepository {

    override suspend fun sendMessage(chatId: Long, text: String): Pair<Message, Message> {
        val messageWrapper = chatDetailedApi.sendMessage(chatId, text)
        return mapToMessage(messageWrapper.message) to mapToMessage(messageWrapper.reply)
    }

    override suspend fun getAllMessagesByChatId(chatId: Long): List<Message> {
        return chatDetailedApi.fetchMessagesByChatId(chatId).messages.map(::mapToMessage)
    }

    override suspend fun deleteMessageById(chatId: Long, messageId: Long) {
        chatDetailedApi.deleteMessageById(chatId, messageId)
    }
}

fun mapToMessage(messageDto: MessageDto): Message {
    return Message(
        id = messageDto.id, text = messageDto.text, isSent = SendingStatus.SENT,
        author = Author.valueOf(messageDto.authorRole)
    )
}
