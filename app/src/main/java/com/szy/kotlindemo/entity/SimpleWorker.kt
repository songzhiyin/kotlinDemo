package com.szy.kotlindemo.entity

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWorker(mContext:Context,params:WorkerParameters):Worker(mContext,params) {
    override fun doWork(): Result {
        Log.i("workManager", "执行了workmanager任务的doWork")
        return Result.success()
    }
}