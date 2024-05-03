package com.rcube.suduku

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

class SudokuGridLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : GridLayout(context, attrs, defStyle) {

    private val rows = 9
    private val columns = 9

    private var currCellWidth = 0
    private var currCellHeight = 0

    private var selectedRow = -1
    private var selectedCol = -1

    private val textViewMatrix = Array(9) { Array<TextView?>(9) { null } }
    
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        val height = measuredHeight

        val cellWidth = width / columns
        val cellHeight = height / rows

        currCellWidth = cellWidth
        currCellHeight = cellHeight

        for (i in 0 until rows) {

            when (i % 3) {
                0, 3, 6 -> drawThickLines(i, "row")
            }

            for (j in 0 until columns) {
                val textView = TextView(context)
                val params = LayoutParams()
                params.width = cellWidth
                params.height = cellWidth
                params.rowSpec = spec(i, 1)
                params.columnSpec = spec(j, 1)

                textView.setTextAppearance(R.style.TableCell)
                textView.gravity = Gravity.CENTER
                textView.tag = "$i$j"
                addView(textView, params)

//                Add cellBorder
                val cellBorder = GradientDrawable()
                cellBorder.setStroke(1, Color.parseColor("#CCCCCC"))
                textView.background = cellBorder

                textViewMatrix[i][j] = textView
            }
        }

        for (j in 0 until columns) {

            when (j % 3) {
                0, 3, 6 -> drawThickLines(j, "col")
            }
        }
    }

    private fun drawThickLines(num: Int, type: String) {
        if (num != 0) {
            val lineView = View(context)
            lineView.setBackgroundColor(Color.BLACK)
            val lineParams = LayoutParams()

            if (type == "row") {
                lineParams.width = currCellWidth * 9
                lineParams.height = 6
                lineParams.rowSpec = spec(num, 1)
                lineParams.columnSpec = spec(0, 9)
            } else {
                lineParams.height = currCellWidth * 9
                lineParams.width = 6
                lineParams.rowSpec = spec(0, 9)
                lineParams.columnSpec = spec(num, 1)
            }

            addView(lineView, lineParams)
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                handleTouchEvent(event.x, event.y)
                true
            }
            else -> false
        }
    }

    // Handle Touch Event
    private fun handleTouchEvent(x: Float, y: Float) {
        val row = (y / currCellWidth).toInt()
        val col = (x / currCellHeight).toInt()

        selectedCol = col
        selectedRow = row

        Log.d("SuDuKU", "Row: $row, Col: $col")

        val textView = textViewMatrix[row][col] as TextView
//        if (textView!= null) {
//            Log.d("SuDuKU", "Before update: ${textView.text}")
//            (context as? OnCellTouch)?.updateTextView(textView)
//            textView.invalidate()
//            Log.d("SuDuKU", "After update: ${textView.text}")
//
//        }

        textView.text = "";
        textView.invalidate()
        val randomNumber = (1..9).random()
        textView.text = randomNumber.toString()

//        val textView = findViewWithTag<TextView>("$row$col")
//        if (textView!= null) {
//                textView.setBackgroundColor(Color.parseColor("#ecd4ee"))
////            (context as? OnCellTouch)?.updateTextView(textView)
//        }
    }

    interface OnCellTouch {
        fun updateTextView(textView: TextView)
    }

}