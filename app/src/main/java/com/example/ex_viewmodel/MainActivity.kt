package com.example.ex_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var postViewModel : PostViewModel
    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postAdapter = PostAdapter()

        post_recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postAdapter
        }

        postViewModel.getPostData()?.observe(this, Observer{
            postAdapter.updatePostList(it)
        })
    }
}