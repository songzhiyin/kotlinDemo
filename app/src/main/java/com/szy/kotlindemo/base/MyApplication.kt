package com.szy.kotlindemo.base

import android.app.Application
import com.szy.kotlindemo.util.ToastUtil

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        ToastUtil.initContext(applicationContext)
    }
}