package com.example.teststartwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

    fun checkmail(view: View) {
        if (loginBox.length() == 0) {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
        }
        else {
            val newActiv = Intent(this,MainWindow::class.java)
            this.startActivity(newActiv)
        }
    }
}