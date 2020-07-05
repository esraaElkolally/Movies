package com.example.postslistapp.model.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ConnectionClient {

    lateinit var connectionAPIs: ConnectionAPIs

    init {
        createRetrofiteInstance()
    }

    fun createRetrofiteInstance() {
        var retrofit = Retrofit.Builder()
            .baseUrl(ConnectionConstants.BASE_URL)
////            .client(getOkHttpClientInstance())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        connectionAPIs = retrofit.create(ConnectionAPIs::class.java)
    }
}