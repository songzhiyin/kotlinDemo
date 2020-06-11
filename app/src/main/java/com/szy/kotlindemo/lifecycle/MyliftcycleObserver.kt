package com.szy.kotlindemo.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.szy.lib.network.Retrofit.Util.LogUtil

class MyliftcycleObserver : LifecycleObserver {
    val TAG = "lifecycleObserver"
    private var activityName: String = "activity"
    private var lifecycle: Lifecycle? = null

    constructor()
    constructor(activityName: String) {
        this.activityName = activityName
    }

    constructor(lifecycles: Lifecycle) {
        this.lifecycle = lifecycle
    }
    constructor(lifecycles: Lifecycle,activityName: String) {
        this.lifecycle = lifecycle
        this.activityName=activityName
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreat() {
        Log.i(TAG, activityName + "的生命周期：oncreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(TAG, activityName + "的生命周期：onstart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(TAG, activityName + "的生命周期：onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(TAG, activityName + "的生命周期：onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(TAG, activityName + "的生命周期：onStop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(TAG, activityName + "的生命周期：onDestroy")
    }

    fun getActivityStatu() {
        Log.i(TAG, "getActivityStatu: " + lifecycle?.currentState)
    }
}