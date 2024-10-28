package `fun`.awesome.chat.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.compose_multiplatform
import awesomechat.composeapp.generated.resources.sad_robot
import `fun`.awesome.chat.presentation.design_system.PrimaryText
import `fun`.awesome.chat.presentation.design_system.SecondaryText
import org.jetbrains.compose.resources.painterResource

@Composable
fun ErrorView() {
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(Res.drawable.sad_robot), contentDescription = null)
        PrimaryText("oops... an error occurred", modifier = Modifier.padding(top = 24.dp, bottom = 12.dp))
        SecondaryText("Check your Internet connection or restart the application")
    }
}
