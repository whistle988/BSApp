package com.example.bsapp.ui.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bsapp.mvp.model.Bs
import com.example.bsapp.R
import com.example.bsapp.ui.activity.MainActivity
import kotlinx.android.synthetic.main.item_view_row.view.*

/*class BsAdapter(val bsList: List<Bs>, val context: HomeFragment): RecyclerView.Adapter<ViewHolder>() {


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


}*/


class BsAdapter(private val bsActivity: MainActivity, private var dataList:List<Bs>):RecyclerView.Adapter<BsAdapter.ViewHolder>() {



    //private val recyclerItemClickListener: BsItemClickListener




    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_view_row, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder:ViewHolder, @SuppressLint("RecyclerView") position:Int) {

        holder.itemView.tvBuild.text = dataList.get(position).build_number
        holder.itemView.tvBranch.text = dataList.get(position).branch
        holder.itemView.tvTargetSystem.text = dataList.get(position).target_system

        /*holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v:View) {
                bsActivity.onMovieItemClick(dataList.get(position))
            }
        })*/


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }
}