package com.example.hypertrophy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hypertrophy.model.network.ExerciseInfo
import com.example.hypertrophy.ui.Screen_BorrowsAllExercise
import com.example.hypertrophy.ui.exerciseInfoCard
import com.example.hypertrophy.ui.theme.HyperTrophyTheme
import com.example.hypertrophy.viewModel.ExercisesViewModel

class MainActivity : ComponentActivity() {
    var exercisesViewModel = ExercisesViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HyperTrophyTheme {
                // A surface container using the 'background' color from the theme

                Screen_BorrowsAllExercise(exercisesViewModel = exercisesViewModel)
            }
        }
    }
}



