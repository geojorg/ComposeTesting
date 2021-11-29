package com.geojorgco.composetesting

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.unit.dp

@Composable
fun ViewS(isShowing: MutableState<Boolean>){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .scale(if (isShowing.value) 0.8f else 1f)
            .offset(
                x = if (isShowing.value) 300.dp else 0.dp,
                y = if (isShowing.value) 44.dp else 0.dp
            )
            .clip(if (isShowing.value) RoundedCornerShape(20.dp) else RoundedCornerShape(0.dp))
            .background(Color.LightGray)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth()
                    ,
            text = "Hola")
    }
}