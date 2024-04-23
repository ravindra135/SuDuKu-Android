package com.rcube.suduku

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.rcube.suduku.databinding.ActivityMainBinding
import com.rcube.suduku.databinding.FragmentGridGroupBinding

class MainActivity : AppCompatActivity(), GridGroup.OnNumberSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private var selectedNumber: String? = null
    private var selectedButton: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        This is used when your xml root is not layout;
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

//        When your xml root is layout
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Call API for new game
        val queue = Volley.newRequestQueue(this)
        val url = "https://sudoku-api.vercel.app/api/dosuku"

        val jsonObjReq = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->

                val gridValue = response.getJSONObject("newboard").getJSONArray("grids").getJSONObject(0).getJSONArray("value")

                val grid = Array(9) { IntArray(9) }

                for(i in 0 until 9) {
                    val row = gridValue.getJSONArray(i)
                    val fragmentInstance = supportFragmentManager.findFragmentByTag("${i + 1}")
                    if(fragmentInstance is GridGroup) {
                        fragmentInstance.updateTextView(row)
                    }
                }
                
                Toast.makeText(this, "Game Started", Toast.LENGTH_SHORT).show()

            },
            { error ->
                Log.e("suduku", "Error: $error")
                Toast.makeText(this, "Cant Fetch Game Data", Toast.LENGTH_SHORT).show()
            }
        )

        MySingleton.getInstance(this).addToRequestQueue(jsonObjReq)
    }

    fun actionBtnClicked(view: View) {
        if(view is Button) {

            toggleBtnState()

            selectedButton = view
            selectedNumber = view.text.toString()

            view.setTextColor(binding.root.context.getColor(R.color.white))
            view.background = binding.root.context.getDrawable(R.drawable.rounded_button_pressed)

//            Toast.makeText(this, "$selectedNumber selected", Toast.LENGTH_SHORT).show()
        }
        
        if(view is ImageButton) {
            toggleBtnState()

            selectedNumber = ""
            selectedButton = view

            val drawable = view.drawable as VectorDrawable
            drawable.setTintList(ColorStateList.valueOf(Color.WHITE))
            view.background = binding.root.context.getDrawable(R.drawable.rounded_button_pressed)

//            Toast.makeText(this, "Delete option selected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun toggleBtnState() {
        if (selectedButton!= null) {
            if (selectedButton is Button) {
                (selectedButton as Button).background = binding.root.context.getDrawable(R.drawable.rounded_button)
                (selectedButton as Button).setTextColor(binding.root.context.getColor(R.color.black))
            } else if (selectedButton is ImageButton) {
                val imageButton = selectedButton as ImageButton
                imageButton.background = binding.root.context.getDrawable(R.drawable.rounded_button)
                val drawable = imageButton.drawable as VectorDrawable
                drawable.setTintList(ColorStateList.valueOf(Color.BLACK))
            }
            selectedButton = null
        }
    }

    override fun onNumberSelected(textView: TextView) {
        if(selectedNumber != null) {
            textView.text = selectedNumber.toString()
        }
    }


    // SingleTon
    class MySingleton constructor(context: Context) {
        companion object {
            @Volatile
            private var INSTANCE: MySingleton? = null
            fun getInstance(context: Context) =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: MySingleton(context).also {
                        INSTANCE = it
                    }
                }
        }

        val requestQueue: RequestQueue by lazy {
            // applicationContext is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            Volley.newRequestQueue(context.applicationContext)
        }
        fun <T> addToRequestQueue(req: Request<T>) {
            requestQueue.add(req)
        }
    }
}