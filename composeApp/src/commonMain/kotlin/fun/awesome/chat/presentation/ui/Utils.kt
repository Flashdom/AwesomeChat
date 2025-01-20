package `fun`.awesome.chat.presentation.ui

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState


suspend fun showSnackbar(message: String, snackbarHostState: SnackbarHostState, ) {
    snackbarHostState.showSnackbar(
        message = message,
        duration = SnackbarDuration.Short
    )
}