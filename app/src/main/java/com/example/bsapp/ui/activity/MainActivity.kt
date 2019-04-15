package com.example.bsapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.TabLayout
import com.example.bsapp.R
import com.example.bsapp.ui.adapter.FragmentPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: FragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
    }

    private fun setupViewPager() {

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
    }


}
