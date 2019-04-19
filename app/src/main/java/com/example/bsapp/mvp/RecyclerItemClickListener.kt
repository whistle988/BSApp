package com.example.bsapp.mvp

import com.example.bsapp.mvp.model.Bs

//This interface is created in order to listen the click callback from the recycler view list.

interface RecyclerItemClickListener {
    abstract fun onItemClick(bs: Bs)
}