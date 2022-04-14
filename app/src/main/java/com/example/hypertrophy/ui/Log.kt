package com.example.hypertrophy

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chargemap.compose.numberpicker.NumberPicker
import com.example.hypertrophy.ui.theme.HyperTrophyTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun LogScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar( title = { Text(text = "Log") }) },
        content = {  },
        bottomBar = { BottomBarNavigation(navController = navController) }
    )
}

@Composable
fun LogScreenUI() {
    // TEMP STATE HOLDERS
    var pickerReps by remember { mutableStateOf(5) }
    var pickerWeights by remember { mutableStateOf(50) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Current Exercise and Set number
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RectangleShape,
            backgroundColor = MaterialTheme.colors.surface,
            border = BorderStroke(2.dp, Color.Black),
            elevation = 8.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "EXERCISE",
                    modifier = Modifier.padding(24.dp),
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = "SET #",
                    modifier = Modifier.padding(18.dp),
                    style = MaterialTheme.typography.h6
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Target reps, editable
            Text("Reps")
            NumberPicker(
                value = pickerReps,
                onValueChange = { pickerReps = it },
                dividersColor = MaterialTheme.colors.secondaryVariant,
                range = 0..250
            )
            // Target weight, editable
            Text("Weight")
            NumberPicker(
                value = pickerWeights,
                onValueChange = { pickerWeights = it },
                dividersColor = MaterialTheme.colors.secondaryVariant,
                range = 0..2500
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Option to duplicate set
            Button(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(8.dp)
            ) {
                Text("Duplicate Set")
            }
            // Option to skip set (mark as incomplete)
            Button(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(8.dp)
            ) {
                Text("Skip Set")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Big, slap-able button to mark set as complete
        Row(
            modifier = Modifier.padding(58.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxSize(),
//                elevation = ButtonElevation.elevation(enabled = true, interactionSource = TODO()),
                shape = MaterialTheme.shapes.medium,
//                colors = /*TODO*/,
                contentPadding = PaddingValues(8.dp)
            ) {
                Text("DONE")
            }
        }
    }
}

@Preview
@Composable
fun PreviewLogScreenUI() {
    HyperTrophyTheme {
        LogScreenUI()
    }
}