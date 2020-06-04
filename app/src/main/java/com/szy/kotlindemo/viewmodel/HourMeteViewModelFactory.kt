package com.szy.kotlindemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HourMeteViewModelFactory(private val number: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HourMeterViewModel(number) as T
    }

}