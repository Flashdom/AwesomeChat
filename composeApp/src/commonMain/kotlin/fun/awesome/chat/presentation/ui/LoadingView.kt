package `fun`.awesome.chat.presentation.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import `fun`.awesome.chat.presentation.design_system.PrimaryText
import `fun`.awesome.chat.presentation.design_system.SecondaryText


@Composable
fun LoadingView() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EternalGradientCircularProgressIndicator()
        PrimaryText("Loading the page", modifier = Modifier.padding(top = 36.dp, bottom = 12.dp))
        SecondaryText("The page is loading, please wait")
    }
}

@Composable
private fun EternalGradientCircularProgressIndicator(
    modifier: Modifier = Modifier,
    strokeWidth: Float = 11f,
    size: Float = 83f,
) {
    // Initialize infinite transition
    val infiniteTransition = rememberInfiniteTransition()
    // Animate a rotation value from 0f to 1f
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1332, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = modifier.size(size.dp)) {
        // Draw the background arc
        drawArc(
            color = Color(255, 255, 255, 0x10),
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(strokeWidth)
        )

        // Create a brush for the gradient
        val gradientBrush = Brush.linearGradient(
            colors = listOf(
                Color(red = 6, green = 207, blue = 241, alpha = 0xFF),
                Color(222, 250, 142, 0xFF)
            ),
            start = Offset(0f, 0f),
            end = Offset(size, size)
        )

        // Calculate sweep angle based on the progress value
        val sweepAngle = 270f
        rotate(progress)
        {
            drawArc(
                brush = gradientBrush,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(strokeWidth)
            )
        }
    }
}
