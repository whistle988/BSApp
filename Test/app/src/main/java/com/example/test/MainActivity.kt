package com.example.test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    private val navigator = object : SupportAppNavigator(this, R.id.mainContainer){

        override fun createActivityIntent(screenKey: String?, data: Any?): Intent? when (screenKey){
            Screens.AUTH_SCREEN -> Intent(this@MainActivity, AuthActivity::class.java)
            else -> null
        }

        override fun createFragmnet(screenKey: String?, data: Any?): Fragment? = when (screenKey){
            Screens.MAIN_SCREEN -> MainFragment()
            Screens.INFO_SCREEN -> InfoFragment.createNewInstance(data as Long)
            Screens.ABOUT_SCREEN -> AboutFragment()
            else -> null
        }
    }
}
