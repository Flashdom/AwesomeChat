package `fun`.awesome.chat.data.chat_list

import `fun`.awesome.chat.domain.repositories.ChatListRepository
import `fun`.awesome.chat.data.chat_list.api.ChatListApi
import `fun`.awesome.chat.data.chat_list.dto.ChatDto
import `fun`.awesome.chat.domain.models.Chat

class ChatListRepositoryImpl(private val chatListApi: ChatListApi) : ChatListRepository {

    override suspend fun createChat(): Chat {
       return Chat(chatListApi.createChat().id, "", "", 0L)
    }

    override suspend fun fetchChats(): List<Chat> {
        return chatListApi.fetchAllChats().chats.map {
            it.mapToChat()
        }
    }

    override suspend fun deleteChatById(chatId: Long) {
        chatListApi.deleteChat(chatId)
    }
}
fun ChatDto.mapToChat(): Chat {
    return Chat(id, title, lastMessage = latestMessages.lastOrNull()?.text?: "", lastMessageAt = 0L)
}
