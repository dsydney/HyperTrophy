package com.example.hypertrophy

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chargemap.compose.numberpicker.NumberPicker
import com.example.hypertrophy.ui.theme.HyperTrophyTheme

@Composable
fun WeighInScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Weigh In") }) },
        content = { },
        bottomBar = { BottomBarNavigation(navController = navController) }
    )
}

@Composable
fun WeighInWeight() {
    //
}

@Composable
fun WeighInDiet() {
    //
}

@Composable
fun WeighInMeasurements() {
    // TEMP STATE HOLDERS
    var upperArmLeft by remember { mutableStateOf("18.5") }
    var upperArmRight by remember { mutableStateOf("18.5") }
    var forearmLeft by remember { mutableStateOf("18.5") }
    var forearmRight by remember { mutableStateOf("18.5") }
    var chest by remember { mutableStateOf("54.0") }
    var thighLeft by remember { mutableStateOf("27.0") }
    var thighRight by remember { mutableStateOf("27.0") }
    var calfLeft by remember { mutableStateOf("18.5") }
    var calfRight by remember { mutableStateOf("18.5") }
    var waist by remember { mutableStateOf("30.0") }
    var shoulder by remember { mutableStateOf("18.5") }

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Upper Arm",
                modifier = Modifier.fillMaxWidth(0.33f),
                textAlign = TextAlign.Left
            )
            TextField(
                value = upperArmLeft,
                onValueChange = { upperArmLeft = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
            TextField(
                value = upperArmRight,
                onValueChange = { upperArmRight = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("right") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Forearm",
                modifier = Modifier.fillMaxWidth(0.33f),
                textAlign = TextAlign.Left
            )
            TextField(
                value = forearmLeft,
                onValueChange = { forearmLeft = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
            TextField(
                value = forearmRight,
                onValueChange = { forearmRight = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("right") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Chest",
                modifier = Modifier.fillMaxWidth(0.33f),
                textAlign = TextAlign.Left
            )
            TextField(
                value = chest,
                onValueChange = { chest = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
//                label = { Text("left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
            Spacer(Modifier.width(96.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Thigh",
                modifier = Modifier.fillMaxWidth(0.33f),
                textAlign = TextAlign.Left
            )
            TextField(
                value = thighLeft,
                onValueChange = { thighLeft = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
            TextField(
                value = thighRight,
                onValueChange = { thighRight = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("right") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Calves",
                modifier = Modifier.fillMaxWidth(0.33f),
                textAlign = TextAlign.Left
            )
            TextField(
                value = calfLeft,
                onValueChange = { calfLeft = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
            TextField(
                value = calfRight,
                onValueChange = { calfRight = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
                label = { Text("right") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Waist",
                modifier = Modifier.fillMaxWidth(0.33f),
                textAlign = TextAlign.Left
            )
            TextField(
                value = waist,
                onValueChange = { waist = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
//                label = { Text("left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
            Spacer(Modifier.width(96.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Shoulder",
                modifier = Modifier.fillMaxWidth(0.33f),
                textAlign = TextAlign.Left
            )
            TextField(
                value = shoulder,
                onValueChange = { shoulder = String.format("%.1f", it) },
                modifier = Modifier.width(96.dp),
//                label = { Text("left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = MaterialTheme.shapes.small
            )
            Spacer(Modifier.width(96.dp))
        }
    }
}

@Composable
fun WeighInBodyFat() {
    // TEMP STATE HOLDERS
    var pickerPercentInt by remember { mutableStateOf(20) }
    var pickerPercentDec by remember { mutableStateOf(5) }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Body Fat Percentage")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberPicker(
                value = pickerPercentInt,
                onValueChange = { pickerPercentInt = it },
                dividersColor = MaterialTheme.colors.secondaryVariant,
                range = 0..99
            )
            Text(".")
            NumberPicker(
                value = pickerPercentDec,
                onValueChange = { pickerPercentDec = it },
                dividersColor = MaterialTheme.colors.secondaryVariant,
                range = 0..9
            )
        }
    }
}

@Preview
@Composable
fun PreviewWeighInMeasurements() {
    HyperTrophyTheme {
        WeighInMeasurements()
    }
}

@Preview
@Composable
fun PreviewWeighInBodyFat() {
    HyperTrophyTheme {
        WeighInBodyFat()
    }
}