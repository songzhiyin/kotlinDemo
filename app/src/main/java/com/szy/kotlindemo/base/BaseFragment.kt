package com.szy.kotlindemo.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.szy.kotlindemo.R
import kotlinx.android.synthetic.main.fragment_base.*

open abstract class BaseFragment : Fragment() {
    protected var mContext: Activity? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = activity
        var view = inflater.inflate(R.layout.fragment_base, container, false)
        return view
    }

    abstract fun getContentViewResId(): Int
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LayoutInflater.from(mContext).inflate(getContentViewResId(), contentView)//将内容布局添加到基础
        initView()
        initdata()
        initEvent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var args = arguments
        getBundleData(args)
    }

    protected open fun getBundleData(savedInstanceState: Bundle?) {

    }

    protected open fun initView() {

    }

    protected open fun initdata() {}
    protected open fun initEvent() {}
    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        activity?.overridePendingTransition(R.anim.zoomin, R.anim.zoomout)//跳转动画
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        activity?.overridePendingTransition(R.anim.zoomin, R.anim.zoomout)//跳转动画
    }
}