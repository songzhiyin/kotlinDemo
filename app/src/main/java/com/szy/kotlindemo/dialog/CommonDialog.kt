package com.szy.kotlindemo.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseDialog
import kotlinx.android.synthetic.main.common_dialog.*

class CommonDialog(mContext: Context) : BaseDialog(mContext) {
    var title = "提示"
    var content = ""
    var cancle = "取消"
    var confirm = "确定"
    var onclickCancle: CallCanclistener? = null
    var onclickConfirm: CallConfirmlistener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_dialog)
        setCanceledOnTouchOutside(false)
        tvTitle.text = title
        tvContent.text = content
        tvCancle.text = cancle
        tvConfirm.text = confirm
        tvCancle.setOnClickListener {
            dismiss()
            onclickCancle?.let { it.onClick() }
        }
        tvConfirm.setOnClickListener {
            dismiss()
            onclickConfirm?.let { it.onClick() }
        }
    }

    fun setContentTitle(message: String) {
        title = message
    }

    fun setContentMessage(message: String) {
        content = message
    }

    fun setContentCancle(message: String) {
        cancle = message
    }

    fun setContentConfirm(message: String) {
        confirm = message
    }

    fun setonclickCancle(onclick: CallCanclistener) {
        onclickCancle = onclick
    }

    fun setonclickConfirm(onclick: CallConfirmlistener) {
        onclickConfirm = onclick
    }

    interface CallCanclistener {
        fun onClick()
    }

    interface CallConfirmlistener {
        fun onClick()
    }
}