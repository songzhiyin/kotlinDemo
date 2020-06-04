package com.szy.kotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import com.google.android.material.snackbar.Snackbar
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.lifecycle.MyliftcycleObserver
import com.szy.kotlindemo.util.ToastUtil
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.activity_drawer_layout.*

/**
 * 左侧滑动菜单
 */
class DrawerLayoutActivity : BaseActivity() {
    lateinit var lifeOberser: MyliftcycleObserver
    override fun getContentId(): Int {
        return (R.layout.activity_drawer_layout)
    }

    override fun initView() {
        super.initView()
        setTitleName("左滑菜单")
        setRightName("菜单")
        lifeOberser = MyliftcycleObserver(lifecycle)
        lifecycle.addObserver(lifeOberser)
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        setRightListener(View.OnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        })
        tvSnackbar.setOnClickListener {
            ToastUtil.showViewListener(contentView, View.OnClickListener {
                ToastUtil.show(mContext, "点击了snacbar")
            }, "确定要点击吗")
        }
        tvLifecycle.setOnClickListener {
            lifeOberser.getActivityStatu()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(lifeOberser)
    }
}