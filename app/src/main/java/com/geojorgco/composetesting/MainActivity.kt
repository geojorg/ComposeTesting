package com.geojorgco.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

    Scaffold(
        modifier = Modifier
            .animateContentSize(animationSpec = tween(durationMillis = 1000,
                easing = LinearOutSlowInEasing)
            ),
                topBar = { TopBar(isShowing) }
    ) {
        Menu()
        ViewS(isShowing)
    }
}


@Composable
@Preview
fun MenuDrawer_Preview(){
    MenuDrawer()
}