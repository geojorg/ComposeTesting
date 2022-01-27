package com.geojorgco.composetesting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Menu(showmenu : ()-> Unit, navController: NavController) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.Black)
    ) {
        Text(
            "Baloto Menu",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "",
            tint = Color.White
        )
        Button(
            onClick = {showmenu()}
        ){
            Text("Close")
        }
        Button(
            onClick = {navController.navigate("page2")}
        ){
            Text("Pagina 2")
        }
        Button(
            onClick = {navController.navigate("page3")}
        ){
            Text("Pagina 3")
        }
    }
}