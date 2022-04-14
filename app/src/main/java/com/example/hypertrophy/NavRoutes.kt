package com.example.hypertrophy

sealed class NavRoutes(val route: String) {
    object Welcome: NavRoutes("welcome")
    object Login: NavRoutes("login")
    object SignUp: NavRoutes("signup")
    object Home: NavRoutes("home")
    object Analyze: NavRoutes("analyze")
    object Templates: NavRoutes("templates")
    object Log: NavRoutes("log")
    object Programs: NavRoutes("programs")
    object Equipment: NavRoutes("equipment")
    object WeighIn: NavRoutes("weighIn")
}