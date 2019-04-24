package com.example.bsapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.example.bsapp.R
import com.example.bsapp.model.BsList
import kotlinx.android.synthetic.main.item_view_row.view.*


class BsAdapter(val context: Context,
                internal var bsList: List<BsList.Bs>):RecyclerView.Adapter<BsAdapter.ViewHolder>(), Filterable {

    internal var filterListResult: List<BsList.Bs>

    init {
        this.filterListResult = bsList
    }


    override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(charString: CharSequence?): FilterResults {
                val charSearch = charString.toString()
                if (charSearch.isEmpty())
                    filterListResult = bsList
                else
                {
                    val resultList = ArrayList<BsList.Bs>()
                    for (row in bsList)
                    {
                        if (row.build_number.toLowerCase().contains(charSearch.toLowerCase()))
                            resultList.add(row)
                    }
                    filterListResult = resultList
                }
                val filterResults = Filter.FilterResults()
                filterResults.values = filterListResult
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                filterListResult = filterResults?.values as List<BsList.Bs>
                notifyDataSetChanged()
            }
        }
    }


    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_view_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filterListResult.size
    }

    override fun onBindViewHolder(holder:ViewHolder, @SuppressLint("RecyclerView") position:Int) {

        holder.itemView.tvBuild.text = filterListResult.get(position).build_number
        holder.itemView.tvBranch.text = filterListResult.get(position).branch
        holder.itemView.tvTargetSystem.text = filterListResult.get(position).target_system

        holder.itemView.tvBuild.text = filterListResult.get(position).build_number
        //holder.txt_url.text = filterListResult.get(position).url

    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {


    }
}