package com.example.hypertrophy

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar( title = { Text(text = "Home")})},
        content = { HomeContent(navController = navController) },
        bottomBar = { BottomBarNavigation(navController = navController) }
    )
}

@Composable
fun HomeContent(navController: NavHostController) {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            Modifier
                .padding(20.dp)
                .fillMaxWidth(0.8f),
            elevation = 15.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Today's Suggestion:", style = MaterialTheme.typography.h6)
                ClickableText(
                    text = AnnotatedString("Push Day"), // There should be some logic for why this workout is selected
                    style = MaterialTheme.typography.h5,
                    onClick = {  } //Send to this particular Template
                )
            }
        }

        Card(
            Modifier
                .padding(20.dp)
                .fillMaxWidth(0.8f),
            elevation = 15.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Recent Workout", style = MaterialTheme.typography.h6)
                ClickableText(
                    text = AnnotatedString("Chest/Triceps"), // This should be a workout completed recently
                    style = MaterialTheme.typography.h5,
                    onClick = {  } //Send to this particular Template
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.padding(bottom = 60.dp, end = 20.dp).fillMaxSize()
        ) {
            IconButton(onClick = {
                Toast.makeText(context, "Click on a workout to start", Toast.LENGTH_LONG).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = ""
                )
            }
        }
    }
}