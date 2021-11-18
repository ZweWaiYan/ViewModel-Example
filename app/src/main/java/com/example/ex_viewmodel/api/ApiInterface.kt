package com.example.ex_viewmodel.api

import com.example.ex_viewmodel.model.MainPost
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPost(): Call<MainPost>
}