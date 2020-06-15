package com.szy.kotlindemo.activity.function

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.viewmodel.HourMeteViewModelFactory
import com.szy.kotlindemo.viewmodel.HourMeterViewModel
import kotlinx.android.synthetic.main.activity_hour_meter.*

/**
 * 计时器试验viewmodel
 */
class HourMeterActivity : BaseActivity() {
    lateinit var viewModel: HourMeterViewModel
    override fun getContentId(): Int {
        return (R.layout.activity_hour_meter)
    }

    override fun initView() {
        super.initView()
        setTitleName("viewmodel")
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        tvAdd.setOnClickListener {
           viewModel.addCount()
        }
        tvDelete.setOnClickListener {
            viewModel.deleteCount()
        }
        tvAsynLoad.setOnClickListener {
            viewModel.startHourMeter()
        }
    }

    override fun initData() {
        super.initData()
        //没有构造参数
//        viewModel = ViewModelProviders.of(this).get(HourMeterViewModel::class.java)
        //viewmodel需要传递构造参数的写法
        viewModel=ViewModelProviders.of(this, HourMeteViewModelFactory(12)).get(HourMeterViewModel::class.java)
        viewModel.counter.observe(this, Observer {
            tvCounter.text = "计数器：" + it
        })
    }


}