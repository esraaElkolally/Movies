package com.example.postslistapp.view.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postslistapp.R
import com.example.postslistapp.databinding.ActivityPostsBinding
import com.example.postslistapp.model.entities.PostsResponseModel
import com.example.postslistapp.viewmodel.PostsViewModel
import kotlinx.android.synthetic.main.activity_posts.*
import java.util.ArrayList

class PostsActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var binding: ActivityPostsBinding
    lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_posts)
        adapter = PostsAdapter()
        setupRecycle()
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)
        postsViewModel.getPostsList()
        postsViewModel.getPostsList().observe(this, Observer {
            adapter.setModelList(it as ArrayList<PostsResponseModel>)

        })

    }

    private fun setupRecycle() {
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
    }
}

