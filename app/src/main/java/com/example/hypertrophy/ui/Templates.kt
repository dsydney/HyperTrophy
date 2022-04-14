package com.example.hypertrophy

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun ListOfWorkoutTemplatesScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar( title = { Text(text = "Templates") }) },
        content = {  },
        bottomBar = { BottomBarNavigation(navController = navController) }
    )
}

@Composable
fun CreateWorkoutTemplateScreen() {

}