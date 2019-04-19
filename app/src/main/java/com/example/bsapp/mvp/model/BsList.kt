package com.example.bsapp.mvp.model

import com.google.gson.annotations.SerializedName


class BsList {

    @SerializedName("bs_list")
    private lateinit var bsList: List<Bs>

    fun getBsList(): List<Bs> {
        return bsList
    }

    fun setBsList(bs_List: List<Bs>) {
        this.bsList = bs_List
    }
}