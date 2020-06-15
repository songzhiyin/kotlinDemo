package com.szy.kotlindemo.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class RecyclerNoMoveView : RecyclerView {
    constructor(mContext: Context) : super(mContext) {

    }

    constructor(mContext: Context, attributeSet: AttributeSet) : super(mContext, attributeSet) {

    }

    constructor(mContext: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        mContext,
        attributeSet,
        defStyleAttr
    )

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        return false
    }
}