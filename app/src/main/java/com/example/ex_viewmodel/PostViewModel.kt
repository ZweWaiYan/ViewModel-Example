package com.example.ex_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ex_viewmodel.api.ApiClient
import com.example.ex_viewmodel.model.MainPost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel(){

    private var PostData: MutableLiveData<MainPost>? = null
    fun getPostData(): LiveData<MainPost>? {
        if (PostData == null) {
            PostData = MutableLiveData<MainPost>()
            loadQueenData()
        }
        return PostData
    }

    fun loadQueenData(){
        val apiClient = ApiClient()
        val apiCall = apiClient.getPost()

        apiCall.enqueue(object : Callback<MainPost> {
            override fun onResponse(call: Call<MainPost>, response: Response<MainPost>) {
                Log.d("Data" , "Data Loaded")
                PostData!!.value = response.body()
            }

            override fun onFailure(call: Call<MainPost>, t: Throwable) {
                Log.d("Data", "t.toString()}")
            }

        })
    }


}