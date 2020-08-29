package com.example.postslistapp.view.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.postslistapp.R
import com.example.postslistapp.model.entities.Movies
import com.example.postslistapp.viewmodel.PostsViewModel
import kotlinx.android.synthetic.main.activity_posts.*
import java.util.ArrayList

class PostsActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_posts)
        adapter =
            PostsAdapter(this)
        setupRecycle()
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)
        postsViewModel.getPostsList()
        postsViewModel.getPostsList().observe(this, Observer {
            adapter.setModelList(it.data.movies as ArrayList<Movies>)

        })

    }

    private fun setupRecycle() {
        recycleView.layoutManager = GridLayoutManager(this, 2)
        recycleView.adapter = adapter
    }

}

