package com.example.teststartwindow

import com.example.teststartwindow.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getPosts(): Call<MutableList<PostModel>>
}