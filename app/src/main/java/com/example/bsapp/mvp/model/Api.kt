package com.example.bsapp.mvp.model

import com.example.bsapp.mvp.model.Bs
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/*
interface Api {
    @GET("builds/InDriverMobile_Android?count=10")
    fun getBuilds(): Observable<List<Bs>>
}*/
interface Api {
    @GET("builds/InDriverMobile_Android?count=10")
    fun getBuilds(): Call<BsList>
}

/*@GET("bins/1bsqcn/")
fun getNoticeData():Call<NoticeList>*/