package com.example.postslistapp.view.posts

import android.app.Activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.postslistapp.model.common.loadImage
import com.example.postslistapp.App
import com.example.postslistapp.R
import com.example.postslistapp.databinding.ItemPostsBinding
import com.example.postslistapp.model.entities.Movies
import com.example.postslistapp.view.details.DetailsActivity
import com.example.postslistapp.view.posts.PostsAdapter.PostsViewHolder
import java.util.*

class PostsAdapter(val _context: Activity) : RecyclerView.Adapter<PostsViewHolder>() {
    private var modelList = ArrayList<Movies>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val layoutInflater = LayoutInflater.from(_context)
        val binding: ItemPostsBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_posts,
            parent, false
        )

        return PostsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        modelList.let {
            holder.binding.itemModel = modelList[position]
            holder.binding.movieImage.loadImage(modelList[position].medium_cover_image)
            setListeners(holder.binding.root, modelList[position])
        }
        holder.binding.executePendingBindings()
    }

    private fun setListeners(container: View, movie: Movies) {
        container.setOnClickListener {
            DetailsActivity.open(activity = _context, movieModel = movie)
        }
    }


    override fun getItemCount(): Int {
        return modelList.size
    }

    fun setModelList(modelList: ArrayList<Movies>) {
        this.modelList = modelList
        notifyDataSetChanged()
    }

    class PostsViewHolder(val binding: ItemPostsBinding) :
        ViewHolder(binding.root) {

    }
}



