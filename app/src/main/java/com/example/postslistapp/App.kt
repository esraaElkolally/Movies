package com.example.postslistapp

import android.app.Application
import android.content.Context

class App : Application() {

companion object{
    lateinit var appContext: Context

    fun getContext():Context{
        return appContext
    }

}

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }
}