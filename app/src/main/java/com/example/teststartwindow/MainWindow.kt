package com.example.teststartwindow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teststartwindow.model.PostModel
import kotlinx.android.synthetic.main.activity_main_window.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_window)
        supportActionBar?.hide()


        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getPosts()

        val recycleView = findViewById<RecyclerView>(R.id.myRecyclerView)

        call.enqueue(object : retrofit2.Callback<MutableList<PostModel>>{
            override fun onResponse(call: Call<MutableList<PostModel>>, response: Response<MutableList<PostModel>>) {

                if (response.isSuccessful){
                    Log.e("success",response.body().toString())

                    recycleView.apply {
                        layoutManager = LinearLayoutManager(this@MainWindow)
                        adapter = PostAdapter(response.body()!!)
                    }

                }
            }

            override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })
        }
    }
