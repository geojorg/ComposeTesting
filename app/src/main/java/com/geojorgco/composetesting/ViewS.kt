package com.geojorgco.composetesting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun ViewS(isShowing: MutableState<Boolean>, algoAnimation: IntOffset, menuAnimation: Float){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .scale(menuAnimation)
            .offset {
                algoAnimation
            }
            .clip(if (isShowing.value) RoundedCornerShape(20.dp) else RoundedCornerShape(0.dp))
            .background(Color.LightGray)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Hola")
    }
}