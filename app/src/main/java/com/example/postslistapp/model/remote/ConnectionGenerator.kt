package com.example.postslistapp.model.remote

import com.example.postslistapp.model.entities.MovieModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable

class ConnectionGenerator {
    companion object {
        fun getPostsList(): Flowable<MovieModel>{

            return ConnectionClient.connectionAPIs.getPostsList().distinct()
        }


    }
}