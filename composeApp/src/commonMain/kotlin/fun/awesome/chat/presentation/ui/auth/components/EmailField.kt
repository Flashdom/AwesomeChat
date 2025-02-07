package `fun`.awesome.chat.presentation.ui.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import `fun`.awesome.chat.presentation.design_system.AppOutlinedTextField
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import awesomechat.composeapp.generated.resources.Res
import awesomechat.composeapp.generated.resources.auth_email
import org.jetbrains.compose.resources.stringResource


@Composable
fun EmailField(
    email: String,
    onEmailChange: (String) -> Unit
) {
    AppOutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = stringResource(Res.string.auth_email),
        leadingIcon = EmailIcon
    )
}

val EmailIcon: ImageVector
    get() {
        if (_EmailIcon != null) {
            return _EmailIcon!!
        }
        _EmailIcon = ImageVector.Builder(
            name = "EmailIcon",
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
                moveTo(21f, 15.094f)
                curveTo(21f, 17.86f, 19.155f, 20.107f, 16.418f, 20.1f)
                horizontalLineTo(7.582f)
                curveTo(4.845f, 20.107f, 3f, 17.86f, 3f, 15.094f)
                verticalLineTo(8.913f)
                curveTo(3f, 6.151f, 4.845f, 3.9f, 7.582f, 3.9f)
                horizontalLineTo(16.418f)
                curveTo(19.155f, 3.9f, 21f, 6.151f, 21f, 8.913f)
                verticalLineTo(15.094f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF040404)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(17.305f, 8.91f)
                lineTo(13.306f, 12.162f)
                curveTo(12.553f, 12.76f, 11.485f, 12.76f, 10.732f, 12.162f)
                lineTo(6.699f, 8.91f)
            }
            path(
                stroke = SolidColor(Color(0xFF040404)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(9.963f, 11.542f)
                lineTo(6.695f, 15.09f)
                moveTo(17.306f, 15.091f)
                lineTo(14.074f, 11.542f)
            }
        }.build()

        return _EmailIcon!!
    }

@Suppress("ObjectPropertyName")
private var _EmailIcon: ImageVector? = null