package com.example.bsapp.network

import com.example.bsapp.RedirectionInfo
import com.example.bsapp.RedirectionInfoDeserializer
import com.google.gson.GsonBuilder
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var instance: Retrofit?=null


    private fun createGsonConverter(): Converter.Factory {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(RedirectionInfo::class.java, RedirectionInfoDeserializer())
        val gson = gsonBuilder.create()
        return GsonConverterFactory.create(gson)
    }


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

