package com.szy.kotlindemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HourMeterViewModel() : ViewModel() {
    var counter = MutableLiveData<Int>()
    constructor(counterReserd: Int):this(){
        counter.value=counterReserd
    }
    fun addCount(){
        val count=counter.value?:0
        counter.value=count+1
    }
    fun deleteCount(){
        counter.value=0
    }

    /**
     * 倒计时
     */
    fun startHourMeter(){
        Thread{
           for (i in 0..10){
               Thread.sleep(300)
               val count=counter.value?:0
               counter.postValue(count+1)
           }
        }.start()
    }

}