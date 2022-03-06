package com.example.asmaa_alshareef.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.asmaa_alshareef.ApiActivity
import com.example.asmaa_alshareef.MyViewModel
import com.example.asmaa_alshareef.R
import kotlinx.android.synthetic.main.item_row_api.view.*

class RecyclerViewAdapter(private val showsList:ArrayList<ArrayList<String>>,val activity: ApiActivity): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    private val myViewModel by lazy { ViewModelProvider(activity).get(MyViewModel::class.java) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_api,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val name=showsList[position][0]
        val language=showsList[position][1]
        val summary=showsList[position][2]
        val link=showsList[position][3]
        holder.itemView.apply {
            buShow.text=name

            buShow.setOnClickListener {
                myViewModel.saveShow(name,language,summary,link)

            }
        }
    }

    override fun getItemCount()=showsList.size
}