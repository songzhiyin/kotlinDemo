package com.szy.kotlindemo.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.szy.lib.network.Retrofit.Util.LogUtil

class MyliftcycleObserver(lifecycles: Lifecycle) : LifecycleObserver {
    val TAG = "lifecycleObserver"
    private var lifecycle: Lifecycle = lifecycles

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreat() {
        Log.i(TAG, "activity的生命周期：oncreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(TAG, "activity的生命周期：onstart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(TAG, "activity的生命周期:onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(TAG, "activity的生命周期:onPause")
    }
    fun getActivityStatu(){
        Log.i(TAG, "getActivityStatu: "+lifecycle?.currentState)
    }
}