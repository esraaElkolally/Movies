package com.example.postslistapp.model.remote

import com.example.postslistapp.model.entities.PostsResponseModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import java.util.*

interface ConnectionAPIs {
    @GET(ConnectionConstants.POSTS_LIST)
    fun getPostsList(): Flowable<List<PostsResponseModel>>

}