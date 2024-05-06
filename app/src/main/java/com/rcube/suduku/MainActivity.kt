package com.rcube.suduku

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

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

        callNewGame()
    }

    // Button Clicked
    fun actionBtnClicked(view: View) {
        // need to set button text to view here;
        when (view) {
            is Button -> sudukuGridLayout.updateCellText(view.text.toString())
            else -> sudukuGridLayout.updateCellText("")
        }
    }

    fun callNewGame() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://sudoku-api.vercel.app/api/dosuku"

        val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null,
            {response ->
                val gridValue = response.getJSONObject("newboard").getJSONArray("grids").getJSONObject(0).getJSONArray("value")
                val solValue = response.getJSONObject("newboard").getJSONArray("grids").getJSONObject(0).getJSONArray("solution")

                val newPuzzule = Array(9) { IntArray(9) }
                val newSolution = Array(9) { IntArray(9) }
                for (i in 0 until 9) {
                    val row = gridValue.getJSONArray(i)
                    val sol = solValue.getJSONArray(i)

                    for (j in 0 until 9) {
                        newPuzzule[i][j] = row.getInt(j)
                        newSolution[i][j] = sol.getInt(j)
                    }
//                    sudukuGridLayout.updateGameData(newPuzzule)
                }
                Log.i("SuDuKu_Game", "Puzzule: ${newPuzzule.joinToString(" ")}")
                Log.i("SuDuKu_Game", "Game Created")
                Toast.makeText(this, "Game Created", Toast.LENGTH_SHORT).show()
            },
            {error ->
                Log.e("SuDuKu_Game", "Error: $error")
                Toast.makeText(this, "Cant Fetch Game Data", Toast.LENGTH_SHORT).show()
            }
        )

        MySingleton.getInstance(this).addToRequestQueue(jsonRequest)
    }
}

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

interface UpdateCell {
    fun updateCellText(num: String)

    fun updateGameData(array: Array<IntArray>)
}