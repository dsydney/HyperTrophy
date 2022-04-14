package com.example.hypertrophy.model.network

import com.google.gson.annotations.SerializedName

data class ExerciseInfo (

    @SerializedName("bodyPart")
    val bodyPart:String,
    @SerializedName("equipment")
    val equipment:String,
    @SerializedName("gifUrl")
    val gifUrl:String,
    @SerializedName("id")
    val id:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("target")
    val target:String,
        )