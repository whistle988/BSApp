package com.example.bsapp.network

import io.reactivex.Observable
import retrofit2.http.GET


interface ApiInterface {
    @GET("builds/InDriverMobile_Android?count=10")
    fun getBs(): Observable<ArrayList<BsList.Bs>>
}
