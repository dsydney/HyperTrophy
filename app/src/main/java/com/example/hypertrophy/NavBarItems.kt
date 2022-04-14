package com.example.hypertrophy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "Analyze",
            image = Icons.Default.Settings,
            route = "analyze"
        ),
        BarItem(
            title = "Templates",
            image = Icons.Default.Build,
            route = "templates"
        ),
        BarItem(
            title = "Log",
            image = Icons.Filled.AccountBox,
            route = "log"
        ),
        BarItem(
            title = "Programs",
            image = Icons.Filled.Search,
            route = "programs"
        ),
        BarItem(
            title = "Equipment",
            image = Icons.Filled.List,
            route = "equipment"
        ),
        BarItem(
            title = "WeighIn",
            image = Icons.Filled.Person,
            route = "weighIn"
        )
    )
}