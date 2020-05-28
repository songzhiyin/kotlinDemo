package com.szy.kotlindemo.util

import java.util.*

object TimeUtil {
    fun showTimeMessage() {
        var calendar = Calendar.getInstance()
        val time = "\n" + calendar.get(Calendar.YEAR) + "年" +
                calendar.get(Calendar.MONTH) + "月" +
                calendar.get(Calendar.DATE) + "日" + " " +
                calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":"+
                calendar.get(Calendar.SECOND)
        print("\n" + time)
        showListofStringMessage()
        showMutableListOfStringMessage()

    }
    fun showListofStringMessage(){
        val data= listOf("吵","擦拭","大","大","大叔大婶")
        for (message in data){
            print("\n"+message)
        }
    }
    fun showMutableListOfStringMessage(){
        val data= mutableListOf("吵","擦拭","大","大","大叔大婶")
        data.add("还有谁")
        for (message in data){
            print("\n"+message)
        }
    }


}