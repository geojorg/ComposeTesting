package com.geojorgco.composetesting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun HomeView(isShowing: MutableState<Boolean>, algoAnimation: IntOffset, menuAnimation: Float){

    val flipped = remember { mutableStateOf(false)}

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

        Image(painter = painterResource(id = R.drawable.card), contentDescription = "Card")
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Card of Clow")
        Spacer(modifier = Modifier.padding(bottom = 200.dp))
        Button(onClick = {}) {
            Text("Flip Card")
        }
    }
}