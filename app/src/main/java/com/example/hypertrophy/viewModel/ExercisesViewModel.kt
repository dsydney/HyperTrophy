package com.example.hypertrophy.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hypertrophy.model.network.ExerciseInfo
import com.example.hypertrophy.model.repository.ExerciseDBHelper
import kotlinx.coroutines.launch
import java.lang.Exception


class ExercisesViewModel:ViewModel() {

    var exerciseList: MutableState<List<ExerciseInfo>> = mutableStateOf(listOf())

    init {
        fetchExercises()
    }

    fun fetchExercises(){

        viewModelScope.launch {

            try {
                val fetchExercisesService = ExerciseDBHelper.getExerciseDBService()
                val responseService = fetchExercisesService.fetchAllExercises()

                if(responseService.isSuccessful){
                    responseService.body()?.let{
                            it ->
                        exerciseList.value = it
                    }
                }else{
                    responseService.errorBody()?.let{
                            ResponseBody ->
                        ResponseBody.close()
                    }
                }
            }catch (e:Exception){

                Log.d("Gale", "Exception in networking $e")

            }
        }
    }
}
