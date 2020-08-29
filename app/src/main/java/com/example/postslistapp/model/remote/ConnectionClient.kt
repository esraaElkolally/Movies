package com.example.postslistapp.model.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ConnectionClient {

    lateinit var connectionAPIs: ConnectionAPIs

    init {
        createRetrofiteInstance()
    }

    fun createRetrofiteInstance() {
        val retrofit = Retrofit.Builder()
            .baseUrl(ConnectionConstants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        connectionAPIs = retrofit.create(ConnectionAPIs::class.java)
    }
}