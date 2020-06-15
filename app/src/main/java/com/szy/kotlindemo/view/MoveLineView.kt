package com.szy.kotlindemo.view

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.widget.Scroller

class MoveLineView : View {
    val TAG="MoveLineView"
    lateinit var mScroller: Scroller

    constructor(mContext: Context) : super(mContext) {

    }

    constructor(mContext: Context, attributeSet: AttributeSet) : super(mContext, attributeSet) {

    }

    constructor(mContext: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        mContext,
        attributeSet,
        defStyleAttr
    )
    init {
        mScroller = Scroller(context)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            var x = it.rawX.toInt()
            var y = it.rawY.toInt()
            var mlastx = 0
            var mlasty = 0

            when (it.action) {
                MotionEvent.ACTION_DOWN -> {

                }
                MotionEvent.ACTION_MOVE -> {
                    val deltax = x - mlastx
                    val deltay = y - mlasty
                    Log.i(TAG, "移动信息：x：$x y：$y deltax：$deltax  deltay：$deltay")
                    smoothScrollTo(deltax,deltay)
                }
                MotionEvent.ACTION_UP -> {

                }
            }
            mlastx = x
            mlasty = y
        }

        return true

    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(event)
    }

    /**
     * 缓慢滑动到指定位置
     */
    fun smoothScrollTo(destX:Int,destY:Int){
        val deltaX=(destX-scaleX).toInt()
        val deltaY=(destY-scaleY).toInt()
        mScroller.startScroll(destX,destY,deltaX,deltaY,1000)
        invalidate()
    }



    override fun computeScroll() {
        super.computeScroll()
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.currX,mScroller.currY)
            postInvalidate()
        }
    }
}