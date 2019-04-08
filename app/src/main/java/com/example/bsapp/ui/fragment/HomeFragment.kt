package com.example.bsapp.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bsapp.dagger.NetworkUtils
import com.example.bsapp.dagger.app.App
import com.example.bsapp.dagger.storage.DatabaseHelper
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    var databaseHelper: DatabaseHelper? = null

    @Inject
    var networkUtils: NetworkUtils? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        App.getComponent().injectHomeFragment(this);


        return inflater.inflate(com.example.bsapp.R.layout.fragment_home, container, false)
    }


}
