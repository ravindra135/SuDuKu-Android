package com.rcube.suduku

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.rcube.suduku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedNumber: String? = null;
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        This is used when your xml root is not layout;
//        binding = ActivityMainBinding.inflate(layoutInflater);
//        setContentView(binding.root)

//        When your xml root is layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Basic Toast
        Toast.makeText(this, "Game Started", Toast.LENGTH_SHORT).show()
        
    }

    fun actionBtnClicked(view: View) {
        if(view is Button) {
            selectedNumber = view.text.toString()
            Toast.makeText(this, "$selectedNumber selected", Toast.LENGTH_SHORT).show()
        }
        
        if(view is ImageButton) {
            Toast.makeText(this, "Delete option selected", Toast.LENGTH_SHORT).show()
        }
    }
}