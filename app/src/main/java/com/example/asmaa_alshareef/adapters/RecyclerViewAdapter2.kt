package com.example.asmaa_alshareef.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.asmaa_alshareef.DBActivity
import com.example.asmaa_alshareef.MyViewModel
import com.example.asmaa_alshareef.R
import com.example.asmaa_alshareef.database.Show
import kotlinx.android.synthetic.main.item_row_db.view.*


class RecyclerViewAdapter2(private val list:List<Show>, val activity: DBActivity): RecyclerView.Adapter<RecyclerViewAdapter2.ItemViewHolder>() {
    class ItemViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    private val myViewModel by lazy { ViewModelProvider(activity).get(MyViewModel::class.java) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_db,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val name=list[position].name
        val language=list[position].language
        val summary=list[position].summary
        val link=list[position].link
        holder.itemView.apply {
            tvName.text=name
            tvLanguage.text=language

                    if(link == ""){
                        imageView.setImageResource(R.drawable.ic_baseline_image_not_supported_24)
                    }else{
                        Glide.with(this).load(link).centerCrop().into(imageView)
                    }



            layout.setOnClickListener {
                Toast.makeText(activity,summary,Toast.LENGTH_LONG).show()
            }

            buDelete.setOnClickListener {
                myViewModel.deleteShow(list[position])
            }
        }
    }

    override fun getItemCount()=list.size
}