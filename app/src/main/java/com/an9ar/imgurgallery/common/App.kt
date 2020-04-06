package com.an9ar.imgurgallery.common

import android.app.Application
import com.an9ar.imgurgallery.api.ServerApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        message = retrofit.create(ServerApi::class.java)
    }

    companion object {
        lateinit var message: ServerApi
            internal set
    }

}