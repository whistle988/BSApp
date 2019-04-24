package com.example.bsapp.ui.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.bsapp.R
import com.example.bsapp.network.ApiClient
import com.example.bsapp.network.BsList
import com.example.bsapp.ui.adapter.BsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



class MainActivity : AppCompatActivity() {

    val mApiClient by lazy {
        ApiClient.create();
    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)

        mApiClient.getBs()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("size", it.size.toString())
                setDataInRecyclerView(it);
            }, {
                Log.d("error", "errors")
            })
    }

    private fun setDataInRecyclerView(it: ArrayList<BsList.Bs>?) {
        recycler_view.adapter = BsAdapter(it!!,this)
    }


}
