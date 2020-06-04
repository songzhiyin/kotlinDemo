package com.szy.kotlindemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HourMeterViewModel() : ViewModel() {
    var counter = 0
    constructor(counterReserd: Int):this(){
        counter=counterReserd
    }

}