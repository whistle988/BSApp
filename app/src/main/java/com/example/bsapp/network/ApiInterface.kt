package com.example.bsapp.network

import com.example.bsapp.mvp.model.BsList
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("builds/InDriverMobile_Android?count=10")
    fun getBs(): Call<BsList>
}
