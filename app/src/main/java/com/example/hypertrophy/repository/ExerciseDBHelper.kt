package com.example.hypertrophy.model.repository

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object ExerciseDBHelper {

    private val retrofit: Retrofit

    init {

        val builder = Retrofit.Builder()
            .baseUrl("https://exercisedb.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(Interceptor { chain ->
                val request: Request =
                    chain.request().newBuilder().addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com").addHeader("X-RapidAPI-Key", "8dc4ece090msh3a73b2cbfbbae53p1cf670jsneb23da7b544a").build()
                chain.proceed(request)
            })
            .writeTimeout(0, TimeUnit.MICROSECONDS)
            .writeTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES).build()

        retrofit = builder.client(okHttpClient).build()
    }

    fun getExerciseDBService(): ExerciseDBService {

        return retrofit.create(ExerciseDBService::class.java)
    }


}