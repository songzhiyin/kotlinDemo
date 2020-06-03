package com.szy.kotlindemo.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.szy.kotlindemo.R

open class BaseDialog : Dialog {
    var mContext: Context? = null

    constructor(mContext: Context) : super(mContext, R.style.Dialog) {
        this.mContext = mContext
    }
    constructor(mContext: Context,thresId:Int):super(mContext,thresId){
        this.mContext=mContext
    }

    protected fun setDialogSize(width: Int, height: Int) {
        if (window != null) {
            val lp: WindowManager.LayoutParams = window.getAttributes()
            lp.width = width
            if (height > 0) {
                lp.height = height
            }
            window.setAttributes(lp)
        }
    }

    override fun show() {
        if (isShowing) {
            return
        }
        try {
            super.show()
        } catch (e: Exception) {
        }
    }

    override fun dismiss() {
        try {
            super.dismiss()
        } catch (var2: Exception) {
            var2.printStackTrace()
        }
    }


}