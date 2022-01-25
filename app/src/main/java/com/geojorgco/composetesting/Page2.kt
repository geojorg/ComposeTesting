package com.geojorgco.composetesting

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toOffset

@Composable
fun Page2() {

    val rotate = remember { mutableStateOf(false) }

    val rotationAngle by animateFloatAsState(
        targetValue = if (rotate.value) 180F else 0F,
        animationSpec = tween(durationMillis = 400,easing = LinearEasing)
    )
    val yTranslation1 by animateIntOffsetAsState(
        targetValue = if (rotate.value) IntOffset(0,-400) else IntOffset(0,0),
        animationSpec = tween(durationMillis = 400,easing = LinearEasing)
    )
    val yTranslation2 by animateIntOffsetAsState(
        targetValue = if (rotate.value) IntOffset(0,-280) else IntOffset(0,0),
        animationSpec = tween(durationMillis = 400,easing = LinearEasing)
    )
    val yTranslation3 by animateIntOffsetAsState(
        targetValue = if (rotate.value) IntOffset(0,-160) else IntOffset(0,0),
        animationSpec = tween(durationMillis = 400,easing = LinearEasing)
    )

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp),
            backgroundColor = Color.Black,
            modifier = Modifier
                .offset {
                    IntOffset(8,yTranslation1.y)
                }
                .padding(start = 4.dp, top = 2.dp)
                .defaultMinSize(40.dp, 40.dp),
            onClick = {  }) {
            Icon(Icons.Filled.Favorite, "")
        }
        FloatingActionButton(
            elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp),
            backgroundColor = Color.Blue,
            modifier = Modifier
                .offset {
                    IntOffset(8,yTranslation2.y)
                }
                .padding(start = 4.dp, top = 2.dp)
                .defaultMinSize(40.dp, 40.dp),
            onClick = {  }) {
            Icon(Icons.Filled.Face, "")
        }
        FloatingActionButton(
            elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp),
            backgroundColor = Color.Red,
            modifier = Modifier
                .offset {
                    IntOffset(8,yTranslation3.y)
                }
                .padding(start = 4.dp, top = 2.dp)
                .defaultMinSize(40.dp, 40.dp),
            onClick = {  }) {
            Icon(Icons.Filled.ArrowForward, "")
        }
        FloatingActionButton(
            elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp),
            modifier = Modifier.rotate(rotationAngle),
            backgroundColor = Color.Black,
            onClick = { rotate.value = !rotate.value}) {
            Icon(Icons.Filled.Add, "")
        }
    }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
        ) {
            Text("Hello")
        }
    }
}