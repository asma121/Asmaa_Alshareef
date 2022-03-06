package com.example.asmaa_alshareef

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.asmaa_alshareef.database.Show
import com.example.asmaa_alshareef.database.ShowsDatabase

class MyViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var Shows: LiveData<List<Show>>
    val ShowDoa= ShowsDatabase.getInstance(application).ShowDao()

    init {
        Shows=ShowDoa.getShows()
    }

    fun getShows(): LiveData<List<Show>>
    {
        return Shows
    }

    fun saveShow(name:String,language:String,summary:String,link:String){
            val show=Show(0,name,language,summary,link)
            ShowDoa.insertShow(show)
    }

    fun deleteShow(show: Show){
        ShowDoa.deleteShow(show)
    }
}