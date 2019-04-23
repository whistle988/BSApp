package com.example.bsapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.bsapp.R
import com.example.bsapp.mvp.BsListModel
import com.example.bsapp.mvp.MainContract
import com.example.bsapp.mvp.BsItemClickListener
import com.example.bsapp.mvp.model.Bs
import com.example.bsapp.mvp.presenter.MainPresenter
import com.example.bsapp.ui.adapter.BsAdapter


class MainActivity : AppCompatActivity(), MainContract.MainView {

    //private lateinit var pagerAdapter: FragmentPagerAdapter

    private val progressBar: ProgressBar? = null
    private val recyclerView: RecyclerView? = null
    lateinit var presenter: MainContract.Presenter

    lateinit var mBsList: MutableList<Bs>
    private var mBsAdapter: BsAdapter? = null
    private var mLayoutManager: GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeRecyclerView()
        initProgressBar()

        //Initializing presenter
        presenter = MainPresenter(this, BsListModel())
        presenter.requestDataFromServer()

        //setupViewPager()
    }

    /*private fun setupViewPager() {

        tabs!!.addTab(tabs.newTab().setText(R.string.BS))
        tabs!!.addTab(tabs.newTab().setText(R.string.Library))
        tabs!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = FragmentPagerAdapter(this, supportFragmentManager, tabs!!.tabCount)
        pager!!.adapter = adapter

        pager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs!!.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab) {
                pager!!.currentItem = tab.position
            }
            override fun onTabUnselected(p0: TabLayout.Tab) {
            }
            override fun onTabReselected(p0: TabLayout.Tab) {
            }
        })
    }*/





    /**
     * Initializing Toolbar and RecyclerView
     */
    private fun initializeRecyclerView() {


        mBsList = ArrayList()
        mBsAdapter = BsAdapter(this, mBsList)

        mLayoutManager = GridLayoutManager(this, 2)
        recyclerView?.layoutManager = mLayoutManager

        recyclerView?.adapter = mBsAdapter



        /*val layoutManager = LinearLayoutManager(this)
        recyclerView?.setLayoutManager(layoutManager)*/


    }


    /**
     * Initializing progressbar programmatically
     * */
    private fun initProgressBar() {

        val progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        progressBar.setIndeterminate(true)

        val relativeLayout = RelativeLayout(this)
        relativeLayout.setGravity(Gravity.CENTER)
        relativeLayout.addView(progressBar)

        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        progressBar.setVisibility(View.INVISIBLE)

        this.addContentView(relativeLayout, params)


    }

    /*private val recyclerItemClickListener = object: BsItemClickListener {

        override fun onItemClick(bs: Bs) {
            Toast.makeText(applicationContext, "Hey!", Toast.LENGTH_LONG).show()

        }
    }*/

    override fun showProgress() {
        progressBar?.setVisibility(View.VISIBLE)
    }

    override fun hideProgress() {
        progressBar?.setVisibility(View.INVISIBLE)
    }

    override fun setDataToRecyclerView(bs_List:List<Bs>) {
        //val adapter = BsAdapter(bs_List, recyclerItemClickListener)
        //recyclerView?.setAdapter(adapter)
        mBsList.addAll(bs_List)
        mBsAdapter!!.notifyDataSetChanged()
    }

    override fun onResponseFailure(throwable:Throwable) {
        Toast.makeText(this, "Something went wrong...Error message: " + throwable.message,
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

