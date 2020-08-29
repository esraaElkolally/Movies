package com.example.postslistapp.model.remote

import com.example.postslistapp.model.entities.MovieModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ConnectionAPIs {
    @GET(ConnectionConstants.POSTS_LIST)
    fun getPostsList(): Flowable<MovieModel>

}