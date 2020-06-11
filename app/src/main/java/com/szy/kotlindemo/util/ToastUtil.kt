package com.szy.kotlindemo.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_base.*

object ToastUtil {
    private var mToast: Toast? = null
    private lateinit var mContext: Context
    fun initContext(context: Context?) {
        if (context != null) {
            this.mContext = context
        }
    }

    fun show(message: String) {
        mToast?.let {
            it.cancel()
            mToast=null
        }
        mContext?.let {
            mToast = Toast.makeText(it, message, Toast.LENGTH_LONG)
            mToast!!.show()
        }

    }

    fun showViewListener(
        contentView: View,
        listener: View.OnClickListener,
        message: String,
        btnName: String
    ) {
        Snackbar.make(contentView, message, Snackbar.LENGTH_SHORT).setAction(btnName, listener)
            .show()
    }

    fun showViewListener(contentView: View, listener: View.OnClickListener, message: String) {
        Snackbar.make(contentView, message, Snackbar.LENGTH_LONG).setAction("确定", listener).show()
    }

}