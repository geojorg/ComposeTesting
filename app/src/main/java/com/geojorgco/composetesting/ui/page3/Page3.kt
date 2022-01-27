package com.geojorgco.composetesting.ui.page3

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun Page3() {

    val switch = remember {
        mutableStateOf(false)
    }

    val expand by animateIntOffsetAsState(
        targetValue = if (!switch.value)
            IntOffset(0, 50) else IntOffset(0, 220),
        animationSpec = tween(
            durationMillis = 200, // duration
            easing = LinearEasing
        ),
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier
            .height(expand.y.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
        ) {
            Row(){
                Text("Algo")
                Switch(checked = switch.value, onCheckedChange = {switch.value = it})
            }
            Text(text = "TESTING", modifier = Modifier.padding(top = 90.dp))
        }
        Spacer(modifier = Modifier.weight(2f))
        DropdownMenu(expanded = true, onDismissRequest = {  }) {

        }
        Spacer(modifier = Modifier.weight(2f))
    }
}