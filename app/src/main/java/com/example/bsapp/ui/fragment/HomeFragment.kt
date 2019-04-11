package com.example.bsapp.ui.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bsapp.Api
import com.example.bsapp.ui.adapter.RViewAdapter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_home.*

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers;

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class HomeFragment : Fragment() {



    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //recycler_view?.layoutManager = LinearLayoutManager(activity)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://bs.sinet.office/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val buildsApi = retrofit.create(Api::class.java)

        val response = buildsApi.getBuilds()

        response.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                recycler_view.adapter = RViewAdapter(it,this)
            }


    }

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(com.example.bsapp.R.layout.fragment_home, container, false)


        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.apply {
            this.layoutManager = LinearLayoutManager(context)

        }
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            //adapter = RViewAdapter(bs)
        }

        fetchJson()
    }*/

    /*fun fetchJson() {
        println("Attempting to Fetch JSON")
        val url = "http://bs.sinet.office/builds/InDriverMobile_Android/2928"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val bs = gson.fromJson(body, Bs::class.java)

                //recycler_view.adapter = RViewAdapter(bs)
            }

            override fun onFailure(call: Call, e: IOException) {
                print("Failed to execute request")
            }
        })
    }*/

    /*fun getBuilds() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)
        val call = api.getBuilds()

        fun<Bs> Call<com.example.bsapp.Bs>.enqueue(callback: Callback<Bs>.() -> Unit) {

            val callBack = Callback<Bs>()
            callback.invoke(call)


            override fun onResponse(call: Call&lt;UsersList&gt;?, response: Response&lt;UsersList&gt;?) {
            var usres = response?.body()
            var user = usres?.users
            var length = user!!.size

            for (i in 0 until length) {
                str = str + "\n" + user.get(i).id + " " + user.get(i).login
            }

            tv_user!!.text = str
        }

            override fun onFailure(call: Call&lt;UsersList&gt;?, t: Throwable?) {
            Log.v("Error", t.toString())
        }
        })
    }*/
}


//class Bs(val builds: List<Builds>)

//class Builds(val build_number: String, val branch: String, val target_system: String, /*val links: Links*/ val playmarket: Boolean)

// class Links(val indriver-debug-2928.apk: String)


//users = builds
//Users = Builds
//UsersList = Bs
