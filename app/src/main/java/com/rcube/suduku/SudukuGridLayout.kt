package com.rcube.suduku

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.gridlayout.widget.GridLayout

class SudokuGridLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : GridLayout(context, attrs, defStyle) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        val height = measuredHeight

        val cellWidth = width / 9
        val cellHeight = height / 9

        for (i in 0 until 81) {
            val textView = getChildAt(i) as TextView
            val params = GridLayout.LayoutParams()
            params.width = cellWidth
            params.height = cellWidth
            params.rowSpec = GridLayout.spec(i / 9, 1)
            params.columnSpec = GridLayout.spec(i % 9, 1)
            textView.layoutParams = params
        }
    }
}