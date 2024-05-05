package com.rcube.suduku

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.gridlayout.widget.GridLayout

class SudukuGridLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : GridLayout(context, attrs, defStyle) {

    private val gameSize = 9
    private var cellSize = 0F

    private val textViewMatrix: Array<Array<TextView?>> = Array(gameSize) { Array<TextView?>(gameSize) { null } }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)

        cellSize = (measuredWidth / gameSize).toFloat()

        val cellBorder = GradientDrawable()
        cellBorder.setStroke(1, Color.parseColor("#CCCCCC"))

        for (i in 0 until gameSize) {

            when (i % 3) {
                0 -> drawThickLines(i, "row")
            }

            for (j in 0 until gameSize) {
                val textView = TextView(context)
                val params = LayoutParams()

                params.width = cellSize.toInt()
                params.height = cellSize.toInt()
                params.rowSpec = spec(i, 1)
                params.columnSpec = spec(j, 1)

                textView.setTextAppearance(R.style.TableCell)
                textView.gravity = Gravity.CENTER
                textView.tag = "$i$j"
                textView.background = cellBorder
                textView.setOnClickListener { setCellText(it) }

                this.textViewMatrix[i][j] = textView
                addView(textView, params)
            }
        }

        for (j in 0 until gameSize) {
            when(j % 3) {
                0 -> drawThickLines(j, "col")
            }
        }
    }

    private fun drawThickLines(num: Int, type: String) {
        if(num != 0) {
            val lineView = View(context)
            lineView.setBackgroundColor(Color.BLACK)

            val lineParams = LayoutParams()
            if(type == "row") {
                lineParams.width = (cellSize * gameSize).toInt()
                lineParams.height = 5
                lineParams.rowSpec = spec(num, 1)
                lineParams.columnSpec = spec(0, 9)
            } else {
                lineParams.height = (cellSize * gameSize).toInt()
                lineParams.width = 5
                lineParams.rowSpec = spec(0, 9)
                lineParams.columnSpec = spec(num, 1)
            }

            addView(lineView, lineParams)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                handleTouchEvent(event.x, event.y)
                true
            } else -> false
        }
    }

    private fun handleTouchEvent(x: Float, y: Float) {
        val row = (y / cellSize).toInt()
        val col = (x / cellSize).toInt()

        textViewMatrix[row][col]?.callOnClick()
        Log.d("SuDuKu_Game", "Row: $row, Col: $col")
    }

    fun setCellText(view: View) {
        val textView = view as TextView
        val randomNumber = (1..9).random()
        textView.text = randomNumber.toString()
    }
}