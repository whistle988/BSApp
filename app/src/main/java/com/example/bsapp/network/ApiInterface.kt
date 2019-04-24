package com.example.bsapp.network

import com.example.bsapp.model.BsList
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiInterface {
    @get:GET("builds/InDriverMobile_Android?count=10")
    val getBs: Observable<List<BsList.Bs>>
}
