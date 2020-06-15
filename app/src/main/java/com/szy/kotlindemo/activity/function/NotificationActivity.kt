package com.szy.kotlindemo.activity.function

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.szy.kotlindemo.R
import com.szy.kotlindemo.activity.home.HomeActivity
import com.szy.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_notification.*

/**
 * notification的推送渠道和发送
 */
class NotificationActivity : BaseActivity() {
    var notifimanage: NotificationManager? = null
    val notifiId = "1101"//推送渠道ID
    var noticeId=1//notification的ID
    var notifiName = "订单消息"//推送渠道的名称
    private val action1="actionmessage"
    var broadcastReceiver:BroadcastReceiver?=null

    override fun getContentId(): Int {
        return (R.layout.activity_notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initView() {
        super.initView()
        setTitleName("发送notification")
        setbackListener()
        notifimanage = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //当Android版本大于8.0之后需要设置推送通道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel =
                NotificationChannel(notifiId, notifiName, NotificationManager.IMPORTANCE_DEFAULT)
            notifimanage?.createNotificationChannel(notificationChannel)
        }
        var intentFilter=IntentFilter()
        intentFilter.addAction(action1)
        broadcastReceiver=MyBrodcastReceive()
        registerReceiver(broadcastReceiver,intentFilter)
    }

    override fun initEvent() {
        super.initEvent()
        //发送普通的notification
        tvSend1.setOnClickListener {
            sendNotification1()
        }
        //发送普通的notification可点击消失
        tvSend2.setOnClickListener {
            sendNotification2()
        }
        //发送可跳转的notification
        tvSend3.setOnClickListener {
            sendNotification3()
        }
        //取消发送的notification消息
        tvCancle.setOnClickListener {
           notifimanage?.cancel(noticeId)
        }
    }

    fun sendNotification1() {
        var notification = NotificationCompat.Builder(this, notifiId)
            .setContentTitle(getString(R.string.app_name))
            .setContentText("新的订单消息")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .build()
        notifimanage?.notify(noticeId, notification)
    }

    fun sendNotification2() {
        val message="点击了通知栏消息发送了broadcastReceiver"
        val intent=Intent(action1).putExtra("data",message)
        var pendingIntent =
            PendingIntent.getBroadcast(mContext!!, 0, intent, 0)
        var notification = NotificationCompat.Builder(this, notifiId)
            .setContentTitle(getString(R.string.app_name))
            .setContentText("新的订单消息")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .setAutoCancel(true)//点击后是否消失
            .setContentIntent(pendingIntent)
            .build()
        notifimanage?.notify(2, notification)
    }

    fun sendNotification3() {
        //PendingIntent获取方法分为getActivity、getService、getBroadcast获取对应的intent
        var pendingIntent =
            PendingIntent.getActivity(mContext!!, 0, Intent(mContext, HomeActivity::class.java), 0)
        var notification = NotificationCompat.Builder(this, notifiId)
            .setContentTitle(getString(R.string.app_name))
            .setContentText("新的订单消息")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        notifimanage?.notify(3, notification)
    }
    inner class MyBrodcastReceive:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let {
                it.getStringExtra("data")?.let {
                    tvMessage.text=it
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        broadcastReceiver?.let {
            unregisterReceiver(it)
        }

    }
}