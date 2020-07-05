package com.example.postslistapp.view.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.postslistapp.App
import com.example.postslistapp.R
import com.example.postslistapp.databinding.ItemPostsBinding
import com.example.postslistapp.model.entities.PostsResponseModel
import com.example.postslistapp.view.posts.PostsAdapter.PostsViewHolder
import kotlinx.android.synthetic.main.item_posts.view.*
import java.util.*

class PostsAdapter : RecyclerView.Adapter<PostsViewHolder>() {
    private var modelList = ArrayList<PostsResponseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val layoutInflater = LayoutInflater.from(App.getContext())
        val binding: ItemPostsBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.item_posts,
            parent, false)
        return PostsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.itemViewbinding.itemModel=modelList[position]
        holder.itemViewbinding.executePendingBindings()

    }
    override fun getItemCount(): Int {
        return modelList.size
    }

    fun setModelList(modelList: ArrayList<PostsResponseModel>) {
        this.modelList = modelList
        notifyDataSetChanged()
    }

     class PostsViewHolder( val itemViewbinding: ItemPostsBinding) : ViewHolder(itemViewbinding.root)
}