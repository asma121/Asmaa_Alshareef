package com.example.asmaa_alshareef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asmaa_alshareef.adapters.RecyclerViewAdapter
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.IOException
import java.net.URL

class ApiActivity : AppCompatActivity() {
    lateinit var rvApi: RecyclerView
    lateinit var buSearch: Button
    lateinit var etSearch: EditText
    var showsListRv = ArrayList<ArrayList<String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        rvApi = findViewById(R.id.rvApi)
        etSearch = findViewById(R.id.etSearch)
        buSearch = findViewById(R.id.buSearch)

        buSearch.setOnClickListener {
            if (etSearch.text.isNotEmpty()) {
                fetchData(etSearch.text.toString())
            } else {
                Toast.makeText(this, " write show's name ", Toast.LENGTH_LONG).show()
            }
            etSearch.text.clear()
        }
    }

    private fun fetchData(word: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val api = URL("https://api.tvmaze.com/search/shows?q=$word")
                .readText(Charsets.UTF_8)
            getData(api)
        }
    }

    private suspend fun getData(api: String) {
            withContext(Dispatchers.Main) {
                val showsList = JSONArray(api)
                for (i in 0 until showsList.length()) {
                    val jsonObject = showsList.getJSONObject(i)
                    val show = jsonObject.getJSONObject("show")
                    /* i can not come over the problem here ..
                     (Value null of type org.json.JSONObject$1 cannot be converted to JSONObject)..
                      this is the solution .. by using try catch for the image just not for all */
                    val showImage = try {
                        show.getJSONObject("image").getString("medium").toString()
                    } catch (e: Exception) {
                        ""
                    }
                    val showSummary = show.getString("summary")
                    val showName = show.getString("name")
                    val showLanguage = show.getString("language")
                    showsListRv.add(arrayListOf(showName, showLanguage, showSummary, showImage))
                }
                rvApi.adapter = RecyclerViewAdapter(showsListRv, this@ApiActivity)
                rvApi.layoutManager = LinearLayoutManager(this@ApiActivity)
            }
    }
}



