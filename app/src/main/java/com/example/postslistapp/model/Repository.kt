package com.example.postslistapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.example.postslistapp.model.entities.PostsResponseModel
import com.example.postslistapp.model.remote.ConnectionGenerator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun getPostsListFromRemote():LiveData<List<PostsResponseModel>>{
        val response=ConnectionGenerator.getPostsList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        return LiveDataReactiveStreams.fromPublisher(response)
    }

}