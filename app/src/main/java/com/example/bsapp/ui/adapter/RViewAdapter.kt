package com.example.bsapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bsapp.Bs
import com.example.bsapp.R
import com.example.bsapp.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.item_view_row.view.*

class RViewAdapter(val bsList: List<Bs>, val context: HomeFragment): RecyclerView.Adapter<ViewHolder>() {


    override fun getItemCount(): Int {
        return bsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_view_row, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.tvBuild.text = bsList.get(position).build_number
        holder.itemView.tvBranch.text = bsList.get(position).branch
        holder.itemView.tvTargetSystem.text = bsList.get(position).target_system
    }

}

class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {


}

