package com.rcube.suduku

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableEdgeToEdge()

        val mainLayout = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("SuDuKu_Game", "Game Created")
        Toast.makeText(this, "Game Created", Toast.LENGTH_SHORT).show()
    }

    // Button Clicked
    fun actionBtnClicked(view: View) {
        // need to set button text to view here;
        if (view is Button) {
            Toast.makeText(this, "${view.text} selected", Toast.LENGTH_SHORT).show()
        } else { // image button
            Toast.makeText(this, "Empty Cell selected", Toast.LENGTH_SHORT).show()
        }
    }
}