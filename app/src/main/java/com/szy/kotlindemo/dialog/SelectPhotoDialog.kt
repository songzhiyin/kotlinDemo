package com.szy.kotlindemo.dialog

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseDialog
import kotlinx.android.synthetic.main.select_photo_take_dialog.*

class SelectPhotoDialog : BaseDialog {
    private var onClickLisetener: OnClickLisetener? = null

    constructor(mContext: Context, onClickLisetener: OnClickLisetener) : super(
        mContext,
        R.style.BottomToTopDialog
    ) {
        this.mContext = mContext
        this.onClickLisetener = onClickLisetener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewWindow()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_photo_take_dialog)
        setCanceledOnTouchOutside(false)
        tvTakePhoto.setOnClickListener {
            onClickLisetener?.onTakePhoto()
            dismiss()
        }
        tvOpenPhoto.setOnClickListener {
            onClickLisetener?.onOpenPhoto()
            dismiss()
        }
        tvCancle.setOnClickListener {
            dismiss()
        }

    }

    private fun initViewWindow() {
        window?.let {
            it.requestFeature(Window.FEATURE_NO_TITLE)
            it.decorView.setPadding(0, 0, 0, 0)
            var lp = it.attributes as WindowManager.LayoutParams
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            lp.windowAnimations = R.style.BottomToTopDialog
            lp.gravity = Gravity.BOTTOM
            window.attributes = lp
            window.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    interface OnClickLisetener {
        fun onTakePhoto()
        fun onOpenPhoto()
    }
}