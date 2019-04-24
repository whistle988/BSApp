package com.example.bsapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bsapp.R
import com.example.bsapp.network.BsList
import kotlinx.android.synthetic.main.item_view_row.view.*


class BsAdapter(val items:ArrayList<BsList.Bs>, val context: Context):RecyclerView.Adapter<BsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_view_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder:ViewHolder, @SuppressLint("RecyclerView") position:Int) {

        holder.itemView.tvBuild.text = items.get(position).build_number
        holder.itemView.tvBranch.text = items.get(position).branch
        holder.itemView.tvTargetSystem.text = items.get(position).target_system

    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }
}