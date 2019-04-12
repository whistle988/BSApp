package com.example.bsapp.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bsapp.ui.fragment.HomeFragment
import com.example.bsapp.ui.fragment.LibraryFragment

class FragmentPagerAdapter(private val myContext: Context, fragmentManager: FragmentManager, internal var totalTabs: Int): FragmentPagerAdapter(fragmentManager){

    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private val mFragmentTitleList: ArrayList<String> = ArrayList()


        override fun getItem(position: Int): Fragment? {
            when(position){
                0 -> {return HomeFragment()
                }
                1 -> {return LibraryFragment()
                }
               else -> return null
            }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}

