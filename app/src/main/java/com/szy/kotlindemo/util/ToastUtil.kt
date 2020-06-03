package com.szy.kotlindemo.util

import android.content.Context
import android.widget.Toast

object ToastUtil {
    public fun show(mContext:Context?,message:String){
        mContext?.let {
            Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
        }
    }
}