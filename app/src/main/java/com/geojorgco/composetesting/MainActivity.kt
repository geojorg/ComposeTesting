package com.geojorgco.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

import com.geojorgco.composetesting.topbar.TopBar
import com.geojorgco.composetesting.ui.theme.ComposeTestingTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
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
    HomeView(isShowing, algoAnimation, menuAnimation)
}


@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    val isShowing = remember { mutableStateOf(false) }

    val name = remember { mutableStateOf("Baloto")}
    var topBarv : @Composable() () -> Unit = {TopBar(isShowing, name)}


    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val name2 = remember { mutableStateOf("Revancha")}


    when (navBackStackEntry?.destination?.route){
        "principal"->{
            topBarv = { TopBar(isShowing, name) }
        }
        "Pagina 2"->{
            topBarv = { TopBar(isShowing, name2) }
        }
        "Pagina 3"->{
            topBarv = { TopBar(isShowing, name2) }
        }
    }

    Scaffold(

        topBar = { topBarv() }


    ) {
        Menu(
            showmenu = { isShowing.value = false },
            navController = navController
        )

        AnimatedNavHost(navController = navController, startDestination = "principal") {
            composable(
                route = "principal",
                exitTransition =  {
                    slideOutHorizontally(targetOffsetX = {-it}, animationSpec = tween(
                        durationMillis = 350,
                        easing = FastOutSlowInEasing
                    ))
                },
                popEnterTransition = {
                    slideInHorizontally( initialOffsetX   = {-1000}, animationSpec = tween(
                        durationMillis = 400,
                        easing = FastOutSlowInEasing
                    ))
                }
            ) {
                MenuDrawer(navController, isShowing)
            }
            composable(
                route = "page2",
                enterTransition =  {
                    slideInHorizontally( initialOffsetX   = {1000}, animationSpec = tween(
                        durationMillis = 400,
                        easing = FastOutSlowInEasing
                    ))
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = {1000}, animationSpec = tween(
                        durationMillis = 400,
                        easing = FastOutSlowInEasing
                    ))
                }
            ) {
                Page2()
                isShowing.value = false
            }
            composable(
                route = "page3",
                enterTransition =  {
                    slideInHorizontally( initialOffsetX   = {1000}, animationSpec = tween(
                        durationMillis = 400,
                        easing = FastOutSlowInEasing
                    ))
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = {1000}, animationSpec = tween(
                        durationMillis = 400,
                        easing = FastOutSlowInEasing
                    ))
                }
            ) {
                NumberPadScreen()
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