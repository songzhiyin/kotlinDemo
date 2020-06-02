package com.szy.kotlindemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            finish()
        }, 1000)
    }
}