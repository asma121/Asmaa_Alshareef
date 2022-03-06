package com.example.asmaa_alshareef.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//class ShowsDatabase {
@Database(entities = [Show::class],version = 1,exportSchema = false)
abstract class ShowsDatabase: RoomDatabase() {

    companion object{
        var instance: ShowsDatabase?=null;
        fun getInstance(ctx: Context):ShowsDatabase
        {
            if(instance !=null)
            {
                return  instance as ShowsDatabase;
            }
            instance = Room.databaseBuilder(ctx, ShowsDatabase::class.java,"Notes_DB").run { allowMainThreadQueries() }.build();
            return instance as ShowsDatabase;
        }
    }
    abstract fun ShowDao(): ShowDao;
}