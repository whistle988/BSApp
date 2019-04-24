package com.example.bsapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var instance: Retrofit?=null

    val getInstance: Retrofit
        get() {
            if (instance == null)
                instance = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://bs.sinet.office/")
                    .build()
            return instance!!
        }

}

