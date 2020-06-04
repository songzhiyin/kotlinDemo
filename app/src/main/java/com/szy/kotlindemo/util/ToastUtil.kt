package com.szy.kotlindemo.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_base.*

object ToastUtil {
     fun show(mContext:Context?,message:String){
        mContext?.let {
            Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
        }
    }
    fun showViewListener(contentView:View,listener:View.OnClickListener,message:String,btnName:String){
        Snackbar.make(contentView,message, Snackbar.LENGTH_SHORT).setAction(btnName,listener).show()
    }
    fun showViewListener(contentView:View,listener:View.OnClickListener,message:String){
        Snackbar.make(contentView,message, Snackbar.LENGTH_LONG).setAction("确定",listener).show()
    }

}