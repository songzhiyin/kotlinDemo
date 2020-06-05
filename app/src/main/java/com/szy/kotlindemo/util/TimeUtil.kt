package com.szy.kotlindemo.util

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {
    private val simpleDateFormat =
        SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
    private val simpleDateFormat2 =
        SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA)
    private val simpleDateFormat3 =
        SimpleDateFormat("MM月dd日", Locale.CHINA)
    private val simpleDateFormat4 =
        SimpleDateFormat("HH:mm", Locale.CHINA)
    private val simpleDateFormat5 =
        SimpleDateFormat("yyyyMMdd", Locale.CHINA)
    private val simpleDateFormat6 =
        SimpleDateFormat("MM.dd HH:mm", Locale.CHINA)
    private val simpleDateFormat7 =
        SimpleDateFormat("MM.dd", Locale.CHINA)
    private val simpleDateFormat8 =
        SimpleDateFormat("yyyy.MM.dd", Locale.CHINA)
    private val simpleDateFormat9 =
        SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)

    fun getDateTimeStr(timestamp: Long): String {
        return simpleDateFormat.format(Date(timestamp))
    }

    fun getDateTimeStr2(timestamp: Long): String {
        return simpleDateFormat2.format(Date(timestamp))
    }

    fun getDateTimeStr3(timestamp: Long): String {
        return simpleDateFormat3.format(Date(timestamp))
    }

    fun getDateTimeStr4(timestamp: Long): String {
        return simpleDateFormat4.format(Date(timestamp))
    }

    fun getDateTimeStr44(date: Date?): String {
        return simpleDateFormat4.format(date)
    }

    fun getDateTimeStr5(timestamp: Long): String {
        return simpleDateFormat5.format(Date(timestamp))
    }

    fun getDateTimeStr6(timestamp: Long): String {
        return simpleDateFormat6.format(Date(timestamp))
    }

    fun getDateTimeStr7(timestamp: Long): String {
        return simpleDateFormat7.format(Date(timestamp))
    }

    fun getDateTimeStr8(timestamp: Long): String {
        return simpleDateFormat8.format(Date(timestamp))
    }

    fun getDateTimeStr9(timestamp: Long): String {
        return simpleDateFormat9.format(Date(timestamp))
    }

    /**
     * 将日期修改为指定的时间
     *
     * @return
     */
    fun getFromDateToTimeHM(
        time: Long,
        hour: String?,
        minute: String?
    ): Long {
        return try {
            val cal = Calendar.getInstance()
            cal.time = Date(time)
            cal[Calendar.HOUR_OF_DAY] = Integer.valueOf(hour) //控制时
            cal[Calendar.MINUTE] = Integer.valueOf(minute) //控制分
            cal[Calendar.SECOND] = 0 //控制秒
            cal.timeInMillis
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            time
        }
    }

    /**
     * 任意一天的数据 00：00：00
     *
     * @return
     */
    fun getStartTimeOfDaily(time: Long): Long {
        val cal = Calendar.getInstance()
        cal.time = Date(time)
        cal[Calendar.HOUR_OF_DAY] = 0 //控制时
        cal[Calendar.MINUTE] = 0 //控制分
        cal[Calendar.SECOND] = 0 //控制秒
        return cal.timeInMillis
    }

    /**
     * 任意一天的数据 23：59：59
     *
     * @return
     */
    fun getEndTimeOfDaily(time: Long): Long {
        val cal = Calendar.getInstance()
        cal.time = Date(time)
        cal[Calendar.HOUR_OF_DAY] = 23 //控制时
        cal[Calendar.MINUTE] = 59 //控制分
        cal[Calendar.SECOND] = 59 //控制秒
        return cal.timeInMillis
    }

}