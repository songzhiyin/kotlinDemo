package com.szy.kotlindemo.activity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : BaseActivity() {
    override fun getContentId(): Int {
        return (R.layout.activity_webview)
    }

    override fun initView() {
        super.initView()
        setTitleName("webview")
        wb.settings.javaScriptEnabled=true
        wb.webViewClient= WebViewClient()
//        wb.loadUrl("https://sth0409.github.io/sth0409.io/index")
        wb.loadUrl("www.baidu.com")
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
    }
}