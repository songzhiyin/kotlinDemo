package com.szy.kotlindemo.activity.launchMode

import com.szy.kotlindemo.R
import com.szy.kotlindemo.activity.home.HomeActivity
import com.szy.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_launch_model1.*

class LaunchModel2Activity : BaseActivity() {
    override fun getContentId(): Int {
        return (R.layout.activity_launch_model2)
    }

    override fun initView() {
        super.initView()
        setTitleName("页面2")
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        tvActivity.setOnClickListener {
            startActivity<HomeActivity>(this)
        }
    }
}