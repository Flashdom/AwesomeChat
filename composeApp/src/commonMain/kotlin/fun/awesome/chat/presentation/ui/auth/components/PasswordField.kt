package `fun`.awesome.chat.presentation.ui.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import `fun`.awesome.chat.presentation.design_system.AppOutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.auth_password
import org.jetbrains.compose.resources.stringResource

@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }

    AppOutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        leadingIcon = KeyIcon,
        trailingIcon = EyeIcon,
        onTrailingIconClick = { passwordVisible = !passwordVisible },
        label = stringResource(Res.string.auth_password),
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

val KeyIcon: ImageVector
    get() {
        if (_KeyIcon != null) {
            return _KeyIcon!!
        }
        _KeyIcon = ImageVector.Builder(
            name = "KeyIcon",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF040404)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15.784f, 9.484f)
                curveTo(15.815f, 10.479f, 15.619f, 11.414f, 15.249f, 12.257f)
                lineTo(19.932f, 16.94f)
                curveTo(20.611f, 17.628f, 20.999f, 18.555f, 20.999f, 19.525f)
                verticalLineTo(19.979f)
                curveTo(20.999f, 20.691f, 20.421f, 21.271f, 19.707f, 21.271f)
                horizontalLineTo(17.352f)
                curveTo(16.638f, 21.271f, 16.06f, 20.691f, 16.06f, 19.979f)
                curveTo(16.06f, 19.278f, 15.503f, 18.706f, 14.803f, 18.688f)
                lineTo(14.723f, 18.685f)
                curveTo(14.013f, 18.666f, 13.453f, 18.079f, 13.467f, 17.369f)
                lineTo(13.485f, 16.428f)
                lineTo(12.391f, 15.335f)
                curveTo(11.158f, 15.996f, 9.669f, 16.265f, 8.115f, 15.958f)
                curveTo(5.571f, 15.458f, 3.535f, 13.375f, 3.097f, 10.821f)
                curveTo(2.389f, 6.704f, 5.64f, 3.136f, 9.664f, 3.303f)
                curveTo(12.956f, 3.439f, 15.68f, 6.192f, 15.784f, 9.484f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF040404)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(10.929f, 9.692f)
                curveTo(10.929f, 8.844f, 10.241f, 8.156f, 9.392f, 8.156f)
                curveTo(8.543f, 8.156f, 7.855f, 8.844f, 7.855f, 9.692f)
                curveTo(7.855f, 10.541f, 8.543f, 11.229f, 9.392f, 11.229f)
                curveTo(10.241f, 11.229f, 10.929f, 10.541f, 10.929f, 9.692f)
                close()
            }
        }.build()

        return _KeyIcon!!
    }

@Suppress("ObjectPropertyName")
private var _KeyIcon: ImageVector? = null

val EyeIcon: ImageVector
    get() {
        if (_Eye != null) {
            return _Eye!!
        }
        _Eye = ImageVector.Builder(
            name = "Eye",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF040404)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(15.161f, 12.002f)
                curveTo(15.161f, 13.748f, 13.745f, 15.163f, 12f, 15.163f)
                curveTo(10.253f, 15.163f, 8.839f, 13.748f, 8.839f, 12.002f)
                curveTo(8.839f, 10.255f, 10.253f, 8.84f, 12f, 8.84f)
                curveTo(13.745f, 8.84f, 15.161f, 10.255f, 15.161f, 12.002f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF040404)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(11.998f, 19.304f)
                curveTo(15.806f, 19.304f, 19.289f, 16.566f, 21.25f, 12.002f)
                curveTo(19.289f, 7.438f, 15.806f, 4.7f, 11.998f, 4.7f)
                horizontalLineTo(12.002f)
                curveTo(8.194f, 4.7f, 4.711f, 7.438f, 2.75f, 12.002f)
                curveTo(4.711f, 16.566f, 8.194f, 19.304f, 12.002f, 19.304f)
                horizontalLineTo(11.998f)
                close()
            }
        }.build()

        return _Eye!!
    }

@Suppress("ObjectPropertyName")
private var _Eye: ImageVector? = null
