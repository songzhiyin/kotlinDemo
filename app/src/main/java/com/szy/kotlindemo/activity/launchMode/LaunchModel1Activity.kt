package com.szy.kotlindemo.activity.launchMode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_launch_model1.*

class LaunchModel1Activity : BaseActivity() {

    override fun getContentId(): Int {
        return (R.layout.activity_launch_model1)
    }

    override fun initView() {
        super.initView()
        setTitleName("页面1")
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        tvActivity.setOnClickListener {
            startActivity<LaunchModel2Activity>(this)
        }
    }
}