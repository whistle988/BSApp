package com.example.bsapp.ui.activity

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import com.example.bsapp.R
import com.example.bsapp.model.BsList
import com.example.bsapp.network.ApiClient
import com.example.bsapp.network.ApiInterface
import com.example.bsapp.ui.adapter.BsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers



class MainActivity : AppCompatActivity() {

    /*val mApiClient by lazy {
        ApiClient.create();
    }*/

    lateinit var mApiClient: ApiInterface
    lateinit var adapter: BsAdapter
    var compositeDisposable = CompositeDisposable()

    var dataList: MutableList<BsList.Bs> = ArrayList()
    var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*//Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Filters"*/

        //Init Api
        val retrofit = ApiClient.getInstance
        mApiClient = retrofit.create(ApiInterface::class.java)

        //View
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)

        adapter = BsAdapter(this, dataList)
        recycler_view.adapter = adapter

        fetchData()

    }

    private fun fetchData() {
        compositeDisposable.add(mApiClient.getBs
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{getBs -> displayData(getBs)})
    }

    private fun displayData(getBs: List<BsList.Bs>?) {
        dataList.clear()
        dataList.addAll(getBs!!)
        adapter.notifyDataSetChanged()
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }


    fun onSearch(){

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = findViewById<SearchView>(R.id.et_search)
        searchView!!.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView!!.maxWidth = Int.MAX_VALUE

        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }

        })

    }
        /*mApiClient.getBs()
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
    }*/


}
