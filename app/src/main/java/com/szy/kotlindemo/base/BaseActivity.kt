package com.szy.kotlindemo.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.gyf.immersionbar.ImmersionBar
import com.szy.kotlindemo.R
import kotlinx.android.synthetic.main.activity_base.*

open abstract class BaseActivity : AppCompatActivity() {
    var lineTitle: View? = null
    var tvTitile: TextView? = null
    var tvRight: TextView? = null
    var imgLeft: ImageView? = null
    var imgRight: ImageView? = null
    var mContext: Activity? = null
    var mImmersionBar: ImmersionBar? = null//状态栏
    private var hideStatusBar: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //强制设置为竖屏
        setContentView(R.layout.activity_base)
        LayoutInflater.from(mContext).inflate(getContentId(), contentView)
        initTitleLayout()
        initSionBar()
        initView()
        initData()
        initEvent()
    }

    protected abstract fun getContentId(): Int

    fun initTitleLayout() {
        lineTitle = findViewById(R.id.lineTileLayout)
        lineTitle?.visibility = View.GONE
        tvTitile = findViewById(R.id.tvTitle)
        tvRight = findViewById(R.id.tvRight)
        imgLeft = findViewById(R.id.imgLeft)
        imgRight = findViewById(R.id.imgRight)
    }

    /**
     * 初始化沉浸式的设置
     */
    protected open fun initSionBar() {
        if (hideStatusBar) {//是否屏蔽状态栏的颜色
            mImmersionBar = ImmersionBar.with(this)
                .transparentStatusBar()
                .keyboardEnable(true) //解决软键盘与底部输入框冲突问题
            mImmersionBar?.init()
        } else {
            mImmersionBar = ImmersionBar.with(this)
                .keyboardEnable(true) //解决软键盘与底部输入框冲突问题
                .fitsSystemWindows(true) //使用该属性,必须指定状态栏颜色
                .statusBarColor(R.color.homeColor)
                .statusBarDarkFont(false)//字体颜色为深色，默认为亮色
            mImmersionBar!!.init()
        }
    }

    fun hideStatusBar() {
        hideStatusBar = true
    }

    open fun initView() {}
    open fun initData() {}
    open fun initEvent() {}
    fun setTitleName(name: String) {
        tvTitile?.text = name
        lineTitle?.visibility = View.VISIBLE
    }

    fun setbackListener() {
        imgLeft?.let {
            it.setImageResource(R.mipmap.icon_back_white)
            it.visibility=View.VISIBLE
            it.setOnClickListener { backFinish() }
        }
    }

    /**
     * 自定义返回键
     */
    protected open fun backFinish() {
        finish()
        overridePendingTransition(R.anim.tuimout, R.anim.tuimin) //设置退出界面时的动画效果
    }

    //--------------------重写按钮的点击事件、界面跳转事件、，添加界面跳转动画--------------------------------------
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            backFinish()
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout)//跳转动画
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout)//跳转动画
    }
}