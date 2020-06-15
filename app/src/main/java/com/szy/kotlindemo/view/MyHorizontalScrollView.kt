package com.szy.kotlindemo.view

import android.content.Context
import android.nfc.Tag
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.HorizontalScrollView
import kotlin.math.abs

/**
 * 禁止纵向滑动获取焦点
 */
class MyHorizontalScrollView : HorizontalScrollView {
    val TAG = "onTouchEvent"

    constructor(mContext: Context) : super(mContext) {

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    var lastX = 0f
    var lastY = 0f
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        var intercept = super.onInterceptTouchEvent(ev)
        ev?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastX = it.x
                    lastY = it.y
                }
                MotionEvent.ACTION_MOVE -> {
                    var slopX = abs(it.x - lastX)
                    var slopY = abs(it.y - lastY)
                    if ((slopX > 0 || slopY > 0) && slopX > slopY) {
                        requestDisallowInterceptTouchEvent(false)
                        intercept=true
                    }
                }
                MotionEvent.ACTION_UP->{
                    intercept=false
                }
            }
        }
        return intercept
    }


}