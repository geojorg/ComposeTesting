package com.geojorgco.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                    Navigation(){

                    }
                }
            }
        }
    }
}

@Composable
fun MenuDrawer(navController: NavHostController, isShowing: MutableState<Boolean>) {


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



        ViewS(isShowing, algoAnimation, menuAnimation)
    }


@Composable
fun Navigation(content : @Composable() () -> Unit) {
    val navController = rememberNavController()
    val isShowing = remember { mutableStateOf(false) }
    Scaffold(
        topBar = { TopBar(isShowing) }
    ) {
        Menu(
            showmenu = { isShowing.value = false },
            navController = navController
        )

        NavHost(navController = navController, startDestination = "principal") {
            composable("principal") {
                MenuDrawer(navController, isShowing)
            }
            composable("page2") {
                Page2()
                isShowing.value = false
            }
        }
    }
}


//
//@Composable
//@Preview
//fun MenuDrawer_Preview(){
//    MenuDrawer(navController)
//}