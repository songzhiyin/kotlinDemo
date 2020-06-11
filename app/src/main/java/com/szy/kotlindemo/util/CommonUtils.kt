package com.szy.kotlindemo.util

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.graphics.Paint
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import java.util.*
import kotlin.collections.ArrayList


object CommonUtils {
    private var activitys = ArrayList<Activity>()
    fun addActivity(activity: Activity) {
        activity.let {
            activitys.add(it)
        }
    }

    fun deleteActivity(activity: Activity) {
        activity.let {
            activitys.remove(activity)
        }
    }

    fun cleanActivity() {
        for (entity in activitys) {
            if (entity != null) {
                entity.finish()
            }
        }
    }


    /**
     * 将dp转为px
     */
    fun dipFrompx(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 将px转为dp
     */
    fun pxFromdip(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /**
     * 获取显示屏的宽度
     */
    fun getScreenWidth(activity: Activity): Int {
        val windowManager: WindowManager = activity.getWindowManager()
        val display = windowManager.defaultDisplay
        return display.width
    }

    /**
     * 获取显示屏的高度
     */
    fun getScreenHeight(activity: Activity): Int {
        val windowManager: WindowManager = activity.getWindowManager()
        val display = windowManager.defaultDisplay
        return display.height
    }

    fun getTailorMessgae(
        currentTextView: TextView?,
        messageLift: String,
        messageRight: String
    ): String {
        currentTextView?.let {
            val paint = Paint()
            paint.textSize = it.textSize
            val sizeLift: Float = paint.measureText(messageLift)
            val sizeRight: Float = paint.measureText(messageRight)
            it.text = messageLift + messageRight
            if (sizeLift + sizeRight > it.width && messageLift.length > 0) {
                val message1 = messageLift.substring(0, messageLift.length - 1)
                val message2 = messageRight
                return getTailorMessgae(currentTextView, message1, message2)
            }
        }
        return messageLift + messageRight


    }

    /**
     * 随机生成数字和大小写字母
     *
     * @return
     */
    fun getStringRandom(length: Int): String? {
        var message = ""
        val random = Random()
        //length为几位密码
        for (i in 0 until length) {
            val charOrNum = if (random.nextInt(2) % 2 == 0) "char" else "num"
            //输出字母还是数字
            if ("char".equals(charOrNum, ignoreCase = true)) {
                //输出是大写字母还是小写字母
                val temp = if (random.nextInt(2) % 2 == 0) 65 else 97
                message += (random.nextInt(26) + temp).toChar()
            } else if ("num".equals(charOrNum, ignoreCase = true)) {
                message += random.nextInt(10).toString()
            }
        }
        return message
    }

    fun getMessageSubstring(
        messageLift: String,
        messageRight: String,
        currentTextView: TextView?,
        tvWith:Int
    ): String {
        var message = messageLift + messageRight
        currentTextView?.let {
            if ((getMessageStringW(it, messageLift) + getMessageStringW(it, messageRight)) <= tvWith
            ) {
                return message
            }
            var message1 = messageLift
            var message2 = "..." + messageRight
            message = message1 + message2
            do {
                if (message1.length<5) {
                    return message
                }
                message1 = message1.substring(0, message1.length - 1)
                message = message1 + message2
            } while (getMessageStringW(it, message1) + getMessageStringW(it, message2) > tvWith)

        }

        return message
    }

    fun getMessageStringW(currentTextView: TextView?, message: String): Float {
        var size: Float = 0f
        currentTextView?.let {
            val paint = Paint()
            paint.textSize = it.textSize
            size = paint.measureText(message)
        }
        return size
    }




}