package com.example.asmaa_alshareef.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Shows")
data class Show (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int=0,
                  @ColumnInfo(name = "name") val name:String,
                  @ColumnInfo(name = "language") val language:String,
                  @ColumnInfo(name = "summary") val summary:String,
                  @ColumnInfo(name = "link") val link:String
)
