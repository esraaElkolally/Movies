package com.example.postslistapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.postslistapp.model.Repository
import com.example.postslistapp.model.entities.PostsResponseModel
import com.example.postslistapp.model.remote.ConnectionGenerator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledThreadPoolExecutor

class PostsViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context
    lateinit var list: LiveData<List<PostsResponseModel>>
    var repository: Repository

    init {
        context = application.applicationContext
        repository = Repository()
    }


    fun getPostsList(): LiveData<List<PostsResponseModel>> {
        list = (repository.getPostsListFromRemote())
        return list
    }
}