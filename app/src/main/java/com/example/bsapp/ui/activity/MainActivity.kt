package com.example.bsapp.ui.activity

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.text.Editable
import android.text.TextWatcher
import com.example.bsapp.R
import com.example.bsapp.model.BsList
import com.example.bsapp.network.ApiClient
import com.example.bsapp.network.ApiInterface
import com.example.bsapp.ui.adapter.BsAdapter
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import org.json.*
import org.json.simple.parser.*

class MainActivity : AppCompatActivity() {

    /*val mApiClient by lazy {
        ApiClient.create();
    }*/

    lateinit var mApiClient: ApiInterface
    lateinit var adapter: BsAdapter
    var compositeDisposable = CompositeDisposable()

    var bsList: ArrayList<BsList.Bs> = ArrayList()
    var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init Api
        val retrofit = ApiClient.getInstance
        mApiClient = retrofit.create(ApiInterface::class.java)

        //View
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)

        adapter = BsAdapter(this, bsList)
        recycler_view.adapter = adapter

        fetchData()

        //filter for edittext
        et_search.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }

    private fun filter(text:String) {
        val filteredList: ArrayList<BsList.Bs> = ArrayList()
        for (item in bsList) {
            if (item.build_number.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item)
            }
        }
        adapter.filterList(filteredList)
    }



    private fun fetchData() {
        compositeDisposable.add(mApiClient.getBs
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{getBs -> displayData(getBs)})
    }

    private fun displayData(getBs: List<BsList.Bs>?) {
        bsList.clear()
        bsList.addAll(getBs!!)
        adapter.notifyDataSetChanged()
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }


    /*fun onSearch(){

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

    }*/


}
