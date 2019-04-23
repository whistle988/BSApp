package com.example.bsapp.mvp

import android.util.Log
import com.example.bsapp.network.ApiInterface
import com.example.bsapp.network.ApiClient
import com.example.bsapp.mvp.MainContract.GetBsIntractor.OnFinishedListener
import com.example.bsapp.mvp.model.Bs
import com.example.bsapp.mvp.model.BsList
import retrofit2.*


class BsListModel : MainContract.GetBsIntractor {

    private val TAG = "BsListModel"


    override fun getBsList(onFinishedListener: OnFinishedListener) {


        val apiService = ApiClient().getClient()?.create(ApiInterface::class.java)

        val call = apiService?.getBs()

        call?.enqueue(object : Callback<BsList> {
            override fun onResponse(call: Call<BsList>, response: Response<BsList>) {
                val bss = response.body()?.getBsList()
                Log.d(TAG, "Number of movies received: " + bss?.size)
                onFinishedListener.onFinished(response.body()!!.getBsList())
            }

            override fun onFailure(call: Call<BsList>, t: Throwable) {
                Log.e(TAG, t.toString())
                onFinishedListener.onFailure(t)
            }
        })
    }
}

/*override fun getBsList(onFinishedListener: OnFinishedListener) {

        val apiService = ApiClient.getClient()!!.create(ApiInterface::class.java)

        val call = apiService.getBs()



        call.enqueue(object : Callback<BsList> {
            override fun onResponse(call: Call<BsList>, response: Response<BsList>) {
                val bss = response.body()?.getBsList()
                Log.d(TAG, "Number of movies received: " + bss?.size)
                onFinishedListener.onFinished(response.body()!!.getBsList())
            }

            override fun onFailure(call: Call<BsList>, t: Throwable) {
                Log.e(TAG, t.toString())
                onFinishedListener.onFailure(t)
            }
        })
    }*/