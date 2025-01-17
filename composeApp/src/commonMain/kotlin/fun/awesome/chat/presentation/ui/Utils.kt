package `fun`.awesome.chat.presentation.ui

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState


suspend fun showSnackbar(message: String, snackbarHostState: SnackbarHostState, ) {
    snackbarHostState.showSnackbar(
        message = message,
        duration = SnackbarDuration.Short
    )
}