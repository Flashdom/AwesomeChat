package `fun`.awesome.chat.data.chat_list

import `fun`.awesome.chat.data.chat_list.api.ChatListApi
import `fun`.awesome.chat.data.chat_list.dto.ChatDto
import `fun`.awesome.chat.domain.models.Chat
import `fun`.awesome.chat.domain.repositories.ChatListRepository

class ChatListRepositoryImpl(private val chatListApi: ChatListApi) : ChatListRepository {

    override suspend fun createChat() {
        chatListApi.createChat()
    }

    override suspend fun fetchChats(): List<Chat> {
        return chatListApi.fetchAllChats().chats.map(::mapToChat)
    }

    override suspend fun deleteChatById(chatId: Long) {
        chatListApi.deleteChat(chatId)
    }
}

private fun mapToChat(chatDto: ChatDto): Chat {
    return Chat(chatDto.id, chatDto.title, lastMessage = chatDto.latestMessages.lastOrNull()?.text?: "", lastMessageAt = 0L)
}
