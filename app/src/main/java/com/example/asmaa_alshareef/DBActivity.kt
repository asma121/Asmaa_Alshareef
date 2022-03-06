package com.example.asmaa_alshareef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asmaa_alshareef.adapters.RecyclerViewAdapter2

class DBActivity : AppCompatActivity() {
    lateinit var rvDB:RecyclerView
    lateinit var conLay:ConstraintLayout
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbactivity)

        rvDB=findViewById(R.id.rvDB)
        conLay=findViewById(R.id.conLay)

        myViewModel.getShows().observe(this,{
            shows->rvDB.adapter= RecyclerViewAdapter2(shows,this)
        })
        rvDB.layoutManager=LinearLayoutManager(this)

    }
}