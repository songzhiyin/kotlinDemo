package com.szy.kotlindemo.activity.function

import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.szy.kotlindemo.R
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.entity.SimpleWorker
import kotlinx.android.synthetic.main.activity_work_manager.*
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * 后台任务
 */
class WorkManagerActivity : BaseActivity() {
    var uuid:UUID?=null
    override fun getContentId(): Int {
        return (R.layout.activity_work_manager)
    }

    override fun initView() {
        super.initView()
        setTitleName("workmanager")
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        tvStart.setOnClickListener {
            startLogWork()

        }
        tvStartTimeTask.setOnClickListener {
            startTimeTask()
        }
        tvStopTimeTask.setOnClickListener {
            stopWorkTask()
        }
    }

    /**
     * 开启一个后台任务
     */
    private fun startLogWork() {
        val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java)
//            .setInitialDelay(5,TimeUnit.SECONDS)//延迟执行
            .addTag("log")//设置标签
            .build()
        uuid=request.id
        WorkManager.getInstance(mContext!!).enqueue(request)
    }

    /**
     * 停止后台任务
     */
    private fun stopWorkTask() {
        //取消全部的后台任务
//        WorkManager.getInstance(mContext!!).cancelAllWork()
        //取消指定标签的后台任务
        WorkManager.getInstance(mContext!!).cancelAllWorkByTag("timeTask")
        uuid?.let {
            //取消指定的后台任务(具体某一个)
//            WorkManager.getInstance(mContext!!).cancelWorkById(it)
        }

    }

    /**
     * 执行定时循环后台任务
     */
    private fun startTimeTask() {
        //workerClass——任务执行的class类、repeatInterval——任务执行的间隔时间、repeatIntervalTimeUnit任务间隔的单位
        val request = PeriodicWorkRequest.Builder(SimpleWorker::class.java, 15, TimeUnit.MINUTES)
            .addTag("timeTask")
            .build()
        WorkManager.getInstance(mContext!!).enqueue(request)
    }
}