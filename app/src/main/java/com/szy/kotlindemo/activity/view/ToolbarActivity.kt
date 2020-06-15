package com.szy.kotlindemo.activity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.util.ToastUtil
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : BaseActivity() {
    override fun getContentId(): Int {
        return (R.layout.activity_toolbar)
    }

    override fun initView() {
        super.initView()
        setSupportActionBar(toolbar)
        toolbar.title = "toolbar"
        toolbar.setNavigationIcon(R.mipmap.icon_back_white)
    }

    override fun initEvent() {
        super.initEvent()
        toolbar.setNavigationOnClickListener {
            backFinish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.btn1 -> {
                ToastUtil.show( "按钮1")
            }
            R.id.btn2 -> {
                ToastUtil.show( "按钮2")
            }
            R.id.btn3 -> {
                ToastUtil.show( "按钮3")
            }
        }
        return true
    }

}