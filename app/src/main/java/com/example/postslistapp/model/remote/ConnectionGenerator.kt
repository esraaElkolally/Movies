package com.example.postslistapp.model.remote

import com.example.postslistapp.model.entities.PostsResponseModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

class ConnectionGenerator {
    companion object {
        fun getPostsList(): Flowable<List<PostsResponseModel>>{

            return ConnectionClient.connectionAPIs.getPostsList()
        }


    }
}