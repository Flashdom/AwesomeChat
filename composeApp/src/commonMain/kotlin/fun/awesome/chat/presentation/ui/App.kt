package `fun`.awesome.chat.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import `fun`.awesome.chat.presentation.ui.auth.AuthScreen
import `fun`.awesome.chat.presentation.ui.chat_detailed.ChatDetailedScreen
import `fun`.awesome.chat.presentation.ui.chat_list.ChatListScreen
import `fun`.awesome.chat.presentation.ui.theme.AwesomeChatTheme

@Composable
fun App() {
    AwesomeChatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = rememberNavController(),
                startDestination = Screens.AUTH.name,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                composable(route = Screens.AUTH.name) {
                    AuthScreen()
                }
                composable(route = Screens.CHAT_LIST.name) {
                    ChatListScreen()
                }
                composable(route = Screens.CHAT_DETAILED.name) {
                    ChatDetailedScreen()
                }
            }
        }
    }
}

enum class Screens {
    AUTH,
    CHAT_LIST,
    CHAT_DETAILED
}
