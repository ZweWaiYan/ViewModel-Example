package com.example.ex_viewmodel.api

import com.example.ex_viewmodel.model.MainPost
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val apiInterface : ApiInterface

    init {
        var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getPost(): Call<MainPost>{
        return apiInterface.getPost()
    }
}