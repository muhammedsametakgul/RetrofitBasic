package com.example.retrofittutorial

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
//https://jsonplaceholder.typicode.com/posts/1
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:SimpleApi by  lazy {
        retrofit.create(SimpleApi::class.java)
    }
}