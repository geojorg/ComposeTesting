package com.geojorgco.composetesting

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun HomeView(isShowing: MutableState<Boolean>, algoAnimation: IntOffset, menuAnimation: Float){

    val flipped = remember { mutableStateOf(false)}
    val angle = 180F

    val xRotationAngle by animateFloatAsState(
        targetValue = if (flipped.value) 180F else 0F,
        animationSpec = tween(durationMillis = 1100,easing = LinearEasing)
    )
    val yRotationAngle by animateFloatAsState(
        targetValue = if (flipped.value) 180F else 0F,
        animationSpec = tween(durationMillis = 1100,easing = LinearEasing)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .scale(menuAnimation)
            .offset { algoAnimation }
            .clip(if (isShowing.value) RoundedCornerShape(20.dp) else RoundedCornerShape(0.dp))
            .background(Color.LightGray)
    ) {

        Image(
            painter = painterResource(id = R.drawable.card),
            contentDescription = "Card",
            modifier = Modifier
                .graphicsLayer {
                    rotationY = yRotationAngle
                    rotationX = xRotationAngle
                    cameraDistance = 12f * density
                }
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Card of Clow")
        Spacer(modifier = Modifier.padding(bottom = 200.dp))
        Button(onClick = {flipped.value = !flipped.value}) {
            Text("Flip Card")
        }
    }
}