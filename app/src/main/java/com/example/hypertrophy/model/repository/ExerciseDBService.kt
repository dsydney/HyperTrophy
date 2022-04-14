package com.example.hypertrophy.model.repository

import com.example.hypertrophy.model.network.BodyPart
import com.example.hypertrophy.model.network.ExerciseInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ExerciseDBService {

    @GET("exercises")
    suspend fun fetchAllExercises():Response<List<ExerciseInfo>>

    @GET("exercises/bodyPartList")
    suspend fun fetchBodyPartList():Response<List<String>>

}