package com.example.ex_viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ex_viewmodel.model.MainPostItem
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewMolder>() {

    private var MainPostList : List<MainPostItem> = ArrayList()

    class PostViewMolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: MainPostItem) {
            itemView.post_body.text = data.body
            itemView.post_title.text = data.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewMolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewMolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewMolder, position: Int) {
        holder.bind(MainPostList[position])
    }

    override fun getItemCount(): Int {
        return MainPostList.size
    }

    fun updatePostList(MainPostList: List<MainPostItem>) {
        this.MainPostList = MainPostList
        notifyDataSetChanged()
    }
}