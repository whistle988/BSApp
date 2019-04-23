package com.example.bsapp.ui.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.bsapp.R
import com.example.bsapp.mvp.GetBsIntractorImpl
import com.example.bsapp.mvp.MainContract
import com.example.bsapp.mvp.RecyclerItemClickListener
import com.example.bsapp.mvp.model.Bs
import com.example.bsapp.mvp.presenter.MainPresenter
import com.example.bsapp.ui.adapter.BsAdapter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_home.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers;

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.example.bsapp.mvp.model.Api as Api
import android.util.Log
import com.example.bsapp.mvp.model.BsList
import org.jetbrains.annotations.NotNull
import kotlin.properties.Delegates


/*class HomeFragment : Fragment() {



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
                recycler_view.adapter = BsAdapter(it,this)

            }


    }

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(com.example.bsapp.R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.apply {
            this.layoutManager = LinearLayoutManager(context)

        }
    }


}*/


class HomeFragment() : Fragment(), MainContract.MainView {

    val progressBar: ProgressBar? = null
    val recyclerView: RecyclerView? = null
    lateinit var presenter:MainContract.presenter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View =  inflater.inflate(R.layout.fragment_home, container, false)



        initializeRecyclerView()
        initProgressBar()
        presenter = MainPresenter(this, GetBsIntractorImpl())
        presenter.requestDataFromServer()

        return view

    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecyclerView()
        initProgressBar()


        presenter = MainPresenter(this, GetBsIntractorImpl())
        presenter.requestDataFromServer()

    }*/


    private val recyclerItemClickListener = object: RecyclerItemClickListener {

        override fun onItemClick(bs:Bs) {
            Toast.makeText(activity, "Hey!", Toast.LENGTH_LONG).show()
        }
    }


    /**
     * Initializing Toolbar and RecyclerView
     */
    private fun initializeRecyclerView() {
        //setSupportActionBar(toolbar)


        val layoutManager = LinearLayoutManager(context)
        recyclerView?.setLayoutManager(layoutManager)

    }


    /**
     * Initializing progressbar programmatically
     * */
    private fun initProgressBar() {

        val progressBar = ProgressBar(activity, null, android.R.attr.progressBarStyleLarge)
        progressBar.setIndeterminate(true)

        val relativeLayout = RelativeLayout(activity)
        relativeLayout.setGravity(Gravity.CENTER)
        relativeLayout.addView(progressBar)

        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        progressBar.setVisibility(View.INVISIBLE)

        activity?.addContentView(relativeLayout, params)


    }

    private val mrecyclerItemClickListener = object:RecyclerItemClickListener {
        override fun onItemClick(bs:Bs) {
            Toast.makeText(context, "List title: ", Toast.LENGTH_LONG).show()
        }
    }

    override fun showProgress() {
        progressBar?.setVisibility(View.VISIBLE)
    }

    override fun hideProgress() {
        progressBar?.setVisibility(View.INVISIBLE)
    }

    override fun setDataToRecyclerView(bs_List:List<Bs>) {
        val adapter = BsAdapter(bs_List, mrecyclerItemClickListener)  ///?????????
        recyclerView?.setAdapter(adapter)
    }

    override fun onResponseFailure(throwable:Throwable) {
        Toast.makeText(activity, "Something went wrong...Error message: " + throwable.message,
            Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    /*override fun onCreateOptionsMenu(menu:Menu):Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }*/

    /*override fun onOptionsItemSelected(item: MenuItem):Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()
        if (id == R.id.action_refresh)
        {
            presenter.onRefreshButtonClick()
        }
        return super.onOptionsItemSelected(item)
    }*/
}