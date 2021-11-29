package com.geojorgco.composetesting

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.geojorgco.composetesting.topbar.TopBar
import com.geojorgco.composetesting.ui.theme.ComposeTestingTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MenuDrawer()
                }
            }
        }
    }
}

@Composable
fun MenuDrawer(){

    val isShowing = remember { mutableStateOf(false) }
    val geo = LocalDensity.current.density



    val algoAnimation by animateIntOffsetAsState(
        targetValue = if (isShowing.value)
            IntOffset(350*geo.toInt(), 44) else IntOffset(0, 0),
        animationSpec = tween(
            durationMillis = 200, // duration
            easing = LinearEasing
        ),
    )

    val menuAnimation by animateFloatAsState(
        targetValue = if (isShowing.value) 0.8f else 1f,
        animationSpec = tween(durationMillis = 200,easing = LinearEasing)
    )

    Scaffold(
        topBar = { TopBar(isShowing) }
    ) {
        Menu()
        ViewS(isShowing, algoAnimation, menuAnimation)
    }
}


@Composable
@Preview
fun MenuDrawer_Preview(){
    MenuDrawer()
}