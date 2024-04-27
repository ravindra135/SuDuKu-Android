package com.rcube.suduku

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        val height = measuredHeight

        val cellWidth = width / columns
        val cellHeight = height / rows

        for (i in 0 until rows) {
            for (j in 0 until columns) {
                val textView = TextView(context)
                val params = LayoutParams()
                params.width = cellWidth
                params.height = cellWidth
                params.rowSpec = spec(i, 1)
                params.columnSpec = spec(j, 1)

                textView.setTextAppearance(R.style.TableCell)
                textView.gravity = Gravity.CENTER
                addView(textView, params)

//                Add cellBorder
                val cellBorder = GradientDrawable()
                cellBorder.setStroke(1, Color.parseColor("#CCCCCC"))
                textView.background = cellBorder

//                Draw Thick Lines;
                if (i == 2 || i == 5) {
                    val lineView = View(context)
                    lineView.setBackgroundColor(Color.BLACK)
                    val lineParams = LayoutParams()
                    lineParams.width = cellWidth * 9
                    lineParams.height = 6
                    lineParams.rowSpec = spec(i + 1, 1)
                    lineParams.columnSpec = spec(0, 9)
                    addView(lineView, lineParams)
                }
                if (j == 2 || j == 5) {
                    val lineView = View(context)
                    lineView.setBackgroundColor(Color.BLACK)
                    val lineParams = LayoutParams()
                    lineParams.width = 6
                    lineParams.height = cellWidth * 9
                    lineParams.rowSpec = spec(0, 9)
                    lineParams.columnSpec = spec(j + 1, 1)
                    addView(lineView, lineParams)
                }
            }
        }
    }
}