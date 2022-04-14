package com.example.hypertrophy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar( title = { Text(text = "Login") } ) },
        content = { LoginContent(navController = navController) }
    )
}

@Composable
fun LoginContent(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Login")

        val focusManager = LocalFocusManager.current

        var UsernameInput by rememberSaveable{mutableStateOf("")}
        var PasswordInput by rememberSaveable{mutableStateOf("")}

        var showPassword by rememberSaveable { mutableStateOf(false) }

        OutlinedTextField(
            value = UsernameInput,
            onValueChange = { text: String ->
                UsernameInput = text
            },
            label = {
                Text(text = "Username")
            },
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default
        )

        OutlinedTextField(
            value = PasswordInput,
            onValueChange = { text: String ->
                PasswordInput = text
            },
            label = {
                Text(text = "Password")
            },
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                       if (showPassword) {
                           IconButton(onClick = { showPassword = false }) {
                               Icon(
                                   imageVector = Icons.Filled.Lock,
                                   contentDescription = ""
                               )
                           }
                       } else {
                           IconButton(onClick = { showPassword = true }) {
                               Icon(
                                   imageVector = Icons.Filled.Lock,
                                   contentDescription = ""
                               )
                           }
                       }
            },
            keyboardOptions = KeyboardOptions.Default
        )

        Button(
            onClick = { navController.navigate(NavRoutes.Home.route) },
            //enabled = PasswordInput.isNotBlank() && UsernameInput.isNotBlank() //This is only commented out for development purposes.
        ) {
            Text(text = "Login")
        }
    }
}