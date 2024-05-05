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

    private lateinit var sudukuGridLayout: SudukuGridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<View>(R.id.main)
        sudukuGridLayout = findViewById(R.id.suduku_grid)
        enableEdgeToEdge()
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
        when (view) {
            is Button -> sudukuGridLayout.updateCellText(view.text.toString())
            else -> sudukuGridLayout.updateCellText("")
        }
    }
}

interface UpdateCell {
    fun updateCellText(num: String)
}