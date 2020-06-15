package com.szy.kotlindemo.activity.home

import android.content.Intent
import android.os.Handler
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity

class WelcomeActivity : BaseActivity() {
    override fun getContentId(): Int {
        hideStatusBar()
        return (R.layout.activity_welcome)
    }

    override fun initView() {
        super.initView()
        Handler().postDelayed(Runnable {
            startActivity(Intent(mContext, HomeActivity::class.java))
            startActivity<HomeActivity>(this)
            finish()
        }, 1000)
    }
}