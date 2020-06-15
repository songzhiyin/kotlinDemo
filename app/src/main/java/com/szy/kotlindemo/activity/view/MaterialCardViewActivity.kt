package com.szy.kotlindemo.activity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.lib.network.Glide.GlideHelper
import kotlinx.android.synthetic.main.activity_material_card_view.*

/**
 * 卡片布局
 */
class MaterialCardViewActivity : BaseActivity() {
    override fun getContentId(): Int {
        return (R.layout.activity_material_card_view)
    }

    override fun initView() {
        super.initView()
        setTitleName("卡片布局")
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
    }

    override fun initData() {
        super.initData()
        GlideHelper.showImage(mContext,"http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1305/03/c0/20496484_1367549048818.jpg",imgIcon)
        GlideHelper.showImage(mContext,"http://attach.bbs.miui.com/forum/201401/22/134002dhye9qe2g2nq2geu.jpg",imgIcon2)
    }
}