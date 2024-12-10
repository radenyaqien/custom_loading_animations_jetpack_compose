package com.radenyaqien.customloadinganimation

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radenyaqien.customloadinganimation.ui.theme.CustomLoadingAnimationTheme

@Composable
fun PulseLoadingAnimation(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {

    val infiniteTransition = rememberInfiniteTransition(label = "infitite transition")
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        ),
        label = "infinite repeatble")

    Box(
        modifier = modifier
            .size(60.dp)
            .graphicsLayer {
                scaleX = progress
                scaleY = progress
                alpha  = 1f - progress
            }.border(
                width = 5.dp,
                color= color,
                shape = CircleShape
            )
    ) {

    }
}

@Preview
@Composable
private fun PulseLoadingAnimationPreview() {
    CustomLoadingAnimationTheme {
        PulseLoadingAnimation(
            color = Color.Green
        )
    }
}