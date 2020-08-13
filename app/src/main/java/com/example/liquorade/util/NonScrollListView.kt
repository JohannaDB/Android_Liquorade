package com.example.liquorade.util

import android.content.Context
import android.util.AttributeSet
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.ListView


class NonScrollListView : ListView {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
    }

    /**
     * Measure the view and its content to determine the measured width and the measured height
     *
     * @param widthMeasureSpec Horizontal space requirements as imposed by the parent
     * @param heightMeasureSpec Vertical space requirements as imposed by the parent
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
            Int.MAX_VALUE shr 2, MeasureSpec.AT_MOST
        )
        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom)
        val params: ViewGroup.LayoutParams = getLayoutParams()
        params.height = getMeasuredHeight()
    }
}