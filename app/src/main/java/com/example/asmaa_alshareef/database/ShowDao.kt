package com.example.asmaa_alshareef.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ShowDao {
    @Query("SELECT * FROM Shows ORDER BY id DESC")
    fun getShows(): LiveData<List<Show>>

    @Insert
    fun insertShow(show: Show)

    @Delete
    fun deleteShow(show: Show)
}