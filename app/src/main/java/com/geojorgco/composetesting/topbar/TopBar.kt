package com.geojorgco.composetesting.topbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.geojorgco.composetesting.R

@Composable
fun TopBar(isShowing: MutableState<Boolean>) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {isShowing.value = !isShowing.value}) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Baloto",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favorito",
                    tint = Color.White,
                    modifier = Modifier.alpha(0f)
                )
            }
        },
        backgroundColor = colorResource(id = R.color.black)
    )
}