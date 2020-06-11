package com.szy.kotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.util.ToastUtil
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.activity_drawer_layout.*
import rx.exceptions.Exceptions
import java.util.concurrent.Executors

/**
 * 左侧滑动菜单
 */
class DrawerLayoutActivity : BaseActivity() {

    override fun getContentId(): Int {
        return (R.layout.activity_drawer_layout)
    }

    override fun initView() {
        super.initView()
        setTitleName("左滑菜单")
        setRightName("菜单")
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        setRightListener(View.OnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        })
        tvSnackbar.setOnClickListener {
            ToastUtil.showViewListener(contentView, View.OnClickListener {
                ToastUtil.show("点击了snacbar")
            }, "确定要点击吗")
        }
        tvLifecycle.setOnClickListener {
            lifeOberser.getActivityStatu()
        }
        tvBtn1.setOnClickListener {
            ToastUtil.show("按钮1")
        }
        tvBtn2.setOnClickListener {
            ToastUtil.show("按钮2")
        }
        tvBtn3.setOnClickListener {
            ToastUtil.show("按钮3")
        }
        tvBtn4.setOnClickListener {
            ToastUtil.show("按钮4")
        }
        Executors.newCachedThreadPool()
    }


    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(lifeOberser)
    }
}