package com.example.bsapp.network

import com.example.bsapp.mvp.model.BsDeserializer
import com.example.bsapp.mvp.model.BsList
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    var retrofit: Retrofit? = null
    val BASE_URL = "http://bs.sinet.office/"


    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }



}