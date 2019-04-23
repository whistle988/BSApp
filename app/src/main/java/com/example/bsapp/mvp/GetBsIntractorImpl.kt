package com.example.bsapp.mvp

import android.arch.lifecycle.MutableLiveData
import android.hardware.camera2.CaptureFailure
import android.util.Log

import com.example.bsapp.mvp.model.Api
import com.example.bsapp.mvp.model.BsList
import com.example.bsapp.network.RetrofitInstance
import com.example.bsapp.mvp.MainContract.GetBsIntractor.OnFinishedListener
import com.example.bsapp.mvp.model.Bs
import io.reactivex.internal.operators.single.SingleDoAfterSuccess
import org.jetbrains.anko.doAsync
import retrofit2.*


class GetBsIntractorImpl : MainContract.GetBsIntractor {

    override fun getBsList(onFinishedListener: OnFinishedListener) {

        val service = RetrofitInstance.getRetrofitInstance()!!.create(Api::class.java)
        val call: Call<BsList> = service.getBuilds()

        //Log.w("URL Called", call.request().url())

        call.enqueue(object : Callback<BsList> {
            override fun onResponse(call: Call<BsList>, response: Response<BsList>) {
                onFinishedListener.onFinished(response.body()!!.getBsList())
            }

            override fun onFailure(call: Call<BsList>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }

        })



    }
}

