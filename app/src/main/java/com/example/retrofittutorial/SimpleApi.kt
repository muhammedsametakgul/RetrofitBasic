package com.example.retrofittutorial

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun fetchPost():MyPost
}

data class MyPost(
    val title:String,
    val body:String

)