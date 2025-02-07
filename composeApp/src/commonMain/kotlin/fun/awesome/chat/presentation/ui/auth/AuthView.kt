package `fun`.awesome.chat.presentation.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.auth_facebook
import awesomechat.composeapp.generated.resources.auth_forgot_password
import awesomechat.composeapp.generated.resources.auth_google
import awesomechat.composeapp.generated.resources.auth_login_button_text
import awesomechat.composeapp.generated.resources.auth_or_login_with_text
import awesomechat.composeapp.generated.resources.auth_sign_in_content
import awesomechat.composeapp.generated.resources.auth_sign_in_header
import awesomechat.composeapp.generated.resources.facebook_logo
import awesomechat.composeapp.generated.resources.google_logo
import awesomechat.composeapp.generated.resources.robot
import `fun`.awesome.chat.presentation.design_system.IconPosition
import `fun`.awesome.chat.presentation.design_system.PrimaryButton
import `fun`.awesome.chat.presentation.design_system.PrimaryText
import `fun`.awesome.chat.presentation.design_system.SecondaryText
import `fun`.awesome.chat.presentation.design_system.TertiaryText
import `fun`.awesome.chat.presentation.ui.auth.components.EmailField
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import awesomechat.composeapp.generated.resources.auth_privacy_policy
import awesomechat.composeapp.generated.resources.auth_terms_of_use
import `fun`.awesome.chat.presentation.ui.auth.components.PasswordField


@Composable
fun AuthView(onEvent: (AuthEvent) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(64.dp))
        Image(painter = painterResource(Res.drawable.robot), contentDescription = null)
        PrimaryText(
            text = stringResource(Res.string.auth_sign_in_header),
            modifier = Modifier.padding(top = 20.dp, bottom = 16.dp),
            fontSize = 36,
            lineHeight = 40
        )
        SecondaryText(text = stringResource(Res.string.auth_sign_in_content))
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            EmailField(email = email, onEmailChange = { newValue -> email = newValue })
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField(password = password, onPasswordChange = { newValue -> password = newValue })
        }

        //BasicSecureTextField(state = TextFieldState()) may be change to this component later
        TertiaryText(
            text = stringResource(Res.string.auth_forgot_password),
            modifier = Modifier.align(Alignment.End)
        )
        PrimaryButton(stringResource(Res.string.auth_login_button_text), modifier = Modifier.fillMaxWidth().padding(top = 32.dp), onClick = {
            onEvent(AuthEvent.LoginButtonClicked("", ""))
        })
        Row(
            modifier = Modifier.padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.height(1.dp).width(100.dp),
                color = Color(red = 122, green = 128, blue = 140, alpha = 52)
            )
            SecondaryText(
                stringResource(Res.string.auth_or_login_with_text),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            HorizontalDivider(
                modifier = Modifier.height(1.dp).width(100.dp),
                color = Color(red = 122, green = 128, blue = 140, alpha = 52)
            )
        }

        Row(horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth() )
        {
            PrimaryButton(
                text = stringResource(Res.string.auth_google),
                modifier = Modifier.weight(1f),
                onClick = { onEvent(AuthEvent.GoogleAuthClicked)},
                iconPosition = IconPosition.Start(Res.drawable.google_logo),
                buttonColor = MaterialTheme.colorScheme.secondary,
                textColor = MaterialTheme.colorScheme.onSurface
            )
            PrimaryButton(
                text = stringResource(Res.string.auth_facebook),
                modifier = Modifier.weight(1f),
                onClick = { onEvent(AuthEvent.FacebookAuthClicked)},
                iconPosition = IconPosition.Start(Res.drawable.facebook_logo),
                buttonColor = MaterialTheme.colorScheme.secondary,
                textColor = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.height(64.dp))
        Row(
            modifier = Modifier.padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TertiaryText(
                text = stringResource(Res.string.auth_terms_of_use),
                modifier = Modifier.padding(horizontal = 24.dp),
                color = MaterialTheme.colorScheme.onSecondary
            )
            VerticalDivider(
                modifier = Modifier.height(15.dp).width(0.dp),
                color = MaterialTheme.colorScheme.onSecondary,
                thickness = 1.dp
            )
            TertiaryText(
                text = stringResource(Res.string.auth_privacy_policy),
                modifier = Modifier.padding(horizontal = 24.dp),
                color = MaterialTheme.colorScheme.onSecondary
            )

        }
    }
}