package `fun`.awesome.chat.presentation.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
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
import awesomechat.composeapp.generated.resources.auth_privacy_policy
import awesomechat.composeapp.generated.resources.auth_sign_in_content
import awesomechat.composeapp.generated.resources.auth_sign_in_header
import awesomechat.composeapp.generated.resources.auth_terms_of_use
import awesomechat.composeapp.generated.resources.facebook_logo
import awesomechat.composeapp.generated.resources.google_logo
import awesomechat.composeapp.generated.resources.robot
import `fun`.awesome.chat.presentation.design_system.IconPosition
import `fun`.awesome.chat.presentation.design_system.PrimaryButton
import `fun`.awesome.chat.presentation.design_system.PrimaryText
import `fun`.awesome.chat.presentation.design_system.SecondaryText
import `fun`.awesome.chat.presentation.design_system.TertiaryText
import `fun`.awesome.chat.presentation.ui.auth.components.EmailField
import `fun`.awesome.chat.presentation.ui.auth.components.PasswordField
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.*


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AuthView(onEvent: (AuthEvent) -> Unit, windowSizeClass: WindowSizeClass) {

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> AuthViewCompact(onEvent)
        WindowWidthSizeClass.Medium -> AuthViewMedium(onEvent)
        WindowWidthSizeClass.Expanded -> AuthViewExpanded(onEvent)
        else -> AuthViewExpanded(onEvent)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun AuthViewCompact(onEvent: (AuthEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AuthHeader()
        Spacer(modifier = Modifier.height(32.dp))
        AuthForm(onEvent)
        Spacer(modifier = Modifier.height(32.dp))
        AuthFooter()
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun AuthViewMedium(onEvent: (AuthEvent) -> Unit) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(0.4f)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AuthHeader()
        }
        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 64.dp)
                .width(1.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        )
        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AuthForm(onEvent)
            Spacer(modifier = Modifier.height(32.dp))
            AuthFooter()
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun AuthViewExpanded(onEvent: (AuthEvent) -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AuthHeader()
            Spacer(modifier = Modifier.height(32.dp))
            AuthForm(onEvent)
            Spacer(modifier = Modifier.height(32.dp))
            AuthFooter()
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun AuthHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.robot),
            contentDescription = null,
            modifier = Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 120.dp)
        )
        PrimaryText(
            text = stringResource(Res.string.auth_sign_in_header),
            modifier = Modifier.padding(top = 20.dp, bottom = 16.dp),
            fontSize = 36,
            lineHeight = 40
        )
        SecondaryText(text = stringResource(Res.string.auth_sign_in_content))
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun AuthForm(onEvent: (AuthEvent) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    EmailField(email = email, onEmailChange = { newValue -> email = newValue })
    Spacer(modifier = Modifier.height(16.dp))
    PasswordField(password = password, onPasswordChange = { newValue -> password = newValue })

    TertiaryText(
        text = stringResource(Res.string.auth_forgot_password),
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
    )
    PrimaryButton(
        stringResource(Res.string.auth_login_button_text),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        onClick = {
            onEvent(AuthEvent.LoginButtonClicked(email, password))
        })
    Row(
        modifier = Modifier.padding(top = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp),
            color = Color(red = 122, green = 128, blue = 140, alpha = 52)
        )
        SecondaryText(
            stringResource(Res.string.auth_or_login_with_text),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp),
            color = Color(red = 122, green = 128, blue = 140, alpha = 52)
        )
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    )
    {
        PrimaryButton(
            text = stringResource(Res.string.auth_google),
            modifier = Modifier.weight(1f),
            onClick = { onEvent(AuthEvent.GoogleAuthClicked) },
            iconPosition = IconPosition.Start(Res.drawable.google_logo),
            buttonColor = MaterialTheme.colorScheme.secondary,
            textColor = MaterialTheme.colorScheme.onSurface
        )
        PrimaryButton(
            text = stringResource(Res.string.auth_facebook),
            modifier = Modifier.weight(1f),
            onClick = { onEvent(AuthEvent.FacebookAuthClicked) },
            iconPosition = IconPosition.Start(Res.drawable.facebook_logo),
            buttonColor = MaterialTheme.colorScheme.secondary,
            textColor = MaterialTheme.colorScheme.onSurface
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun AuthFooter() {
    Row(
        modifier = Modifier.padding(top = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TertiaryText(
            text = stringResource(Res.string.auth_terms_of_use),
            color = MaterialTheme.colorScheme.onSecondary
        )
        VerticalDivider(
            modifier = Modifier
                .height(16.dp)
                .width(1.dp),
            color = MaterialTheme.colorScheme.onSecondary,
        )
        TertiaryText(
            text = stringResource(Res.string.auth_privacy_policy),
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}