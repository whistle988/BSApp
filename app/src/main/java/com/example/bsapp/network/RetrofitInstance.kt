package com.example.bsapp.network

import com.example.bsapp.mvp.model.Api
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    var retrofit : Retrofit? = null
    val BASE_URL = "http://bs.sinet.office/"
    /**
     * Create an instance of Retrofit object
     * */
    /*val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null)
            {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }*/

    fun getRetrofitInstance():Retrofit? {
        if (retrofit == null)
        {
            retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

        }
        return retrofit
    }

    /*fun create(): RetrofitInstance {

        val retrofit = retrofit2.Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(RetrofitInstance::class.java)
    }*/
}


/*.baseUrl("http://bs.sinet.office/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()*/