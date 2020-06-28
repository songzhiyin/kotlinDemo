package com.szy.kotlindemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.szy.kotlindemo.R

class CircleView : View {
    var color = Color.RED
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(mContext: Context) : super(mContext) {
        initview(mContext)
    }

    constructor(mContext: Context, attrs: AttributeSet) : super(mContext, attrs) {
        var typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CircleView)
        color = typedArray.getColor(R.styleable.CircleView_circle_color, Color.RED)
        initview(mContext)
    }

    constructor(mContext: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        mContext,
        attrs,
        defStyleAttr
    ) {
        var typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CircleView)
        color = typedArray.getColor(R.styleable.CircleView_circle_color, Color.RED)
        initview(mContext)
    }

    private fun initview(mContext: Context) {
        paint.color = color
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var redius = Math.min(
            width - paddingLeft - paddingRight,
            height - paddingTop - paddingBottom
        ) / 2.toFloat()
        val x = (redius + paddingLeft).toFloat()
        val y = (redius + paddingTop).toFloat()
        canvas?.drawCircle(x, y, redius, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec)
        var width = widthMeasureSize
        var height = heightMeasureSize
        when (widthMeasureMode) {
            MeasureSpec.UNSPECIFIED -> width = 200//系统测量的模式
            MeasureSpec.EXACTLY -> width = widthMeasureSize//精确模式例如设置的是match_parent或者是**dp、px
            MeasureSpec.AT_MOST -> width = 200//未指定准确大小，view的宽度是wrap_content
        }
        when (heightMeasureMode) {
            MeasureSpec.UNSPECIFIED -> height = 200
            MeasureSpec.EXACTLY -> height = heightMeasureSize
            MeasureSpec.AT_MOST -> height = 200
        }
        setMeasuredDimension(width, height)
    }
}