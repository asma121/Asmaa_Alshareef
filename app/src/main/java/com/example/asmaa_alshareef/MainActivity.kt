package com.example.asmaa_alshareef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var buApi:Button
    lateinit var buDB:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buApi=findViewById(R.id.buApi)
        buDB=findViewById(R.id.buDB)



        buApi.setOnClickListener {
            val intent=Intent(this,ApiActivity::class.java)
            startActivity(intent)

        }

        buDB.setOnClickListener {
            val intent=Intent(this,DBActivity::class.java)
            startActivity(intent)

        }
    }
}