package com.example.hypertrophy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hypertrophy.database.Exercise
import com.example.hypertrophy.database.Program
import com.example.hypertrophy.database.Sets
import com.example.hypertrophy.database.Template
import com.example.hypertrophy.model.network.ExerciseInfo
import com.example.hypertrophy.ui.test
import com.example.hypertrophy.ui.theme.HyperTrophyTheme
import com.example.hypertrophy.ui.theme.WelcomeScreen
import com.example.hypertrophy.viewModel.ExercisesViewModel
import com.example.hypertrophy.viewModel.ProgramViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val programViewModel = ViewModelProvider(this).get(ProgramViewModel::class.java)
        val exercisesViewModel = ExercisesViewModel()
        setContent {
            HyperTrophyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    SplashScreen()
                }
            }
        }
    }
}

@Composable
fun SplashScreen() {
    //Create a navController here, send it through to the next screen as a parameter
    val navController = rememberNavController()

    //Implement a splashscreen here, then go to WelcomeScreen()
    MainScreen(navController = navController)
}

@Composable
fun MainScreen(navController: NavHostController) {
    //Create NavHost to navigate between welcome and login/signup
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Welcome.route
    ) {
        composable(NavRoutes.Welcome.route) {
            WelcomeScreen(navController = navController)
        }

        composable(NavRoutes.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(NavRoutes.SignUp.route) {
            SignUpScreen(navController = navController)
        }

        composable(NavRoutes.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(NavRoutes.Analyze.route) {
            AnalyzeScreen(navController = navController)
        }

        composable(NavRoutes.Templates.route) {
            ListOfWorkoutTemplatesScreen(navController = navController)
        }

        composable(NavRoutes.Log.route) {
            LogScreen(navController = navController)
        }

        composable(NavRoutes.Programs.route) {
            SuggestedProgramsScreen(navController = navController)
        }

        composable(NavRoutes.Equipment.route) {
            EquipmentMatcherScreen(navController = navController)
        }

        composable(NavRoutes.WeighIn.route) {
            WeighInScreen(navController = navController)
        }

    }
}


@Composable
fun BottomBarNavigation(navController: NavHostController) {
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.BarItems.forEach{ navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                          navController.navigate(navItem.route)
                },
                icon = { Icon(imageVector = navItem.image, contentDescription = navItem.title) },
                //label = { Text(text = navItem.title) }
            )
        }
    }
}