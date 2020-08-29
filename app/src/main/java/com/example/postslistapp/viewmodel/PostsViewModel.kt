package com.example.postslistapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.postslistapp.model.Repository
import com.example.postslistapp.model.entities.MovieModel
import com.example.postslistapp.model.entities.Movies

class PostsViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context
    lateinit var moveModel: LiveData<MovieModel>
    var repository: Repository

    init {
        context = application.applicationContext
        repository = Repository()
    }


    fun getPostsList(): LiveData<MovieModel> {
        moveModel = (repository.getPostsListFromRemote())
        return moveModel
    }
}