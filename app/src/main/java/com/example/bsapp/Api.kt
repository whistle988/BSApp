package com.example.bsapp

import io.reactivex.Observable
import retrofit2.http.GET

public interface Api {
    @GET("builds/InDriverMobile_Android?count=10")
    fun getBuilds(): Observable<List<Bs>>
}