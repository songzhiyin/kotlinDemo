package com.szy.kotlindemo.util

//object修饰词修饰的class类默认是单例模式
object DataHandlerUtil {
    fun showListOf(){
        val data= listOf("12","21","12","12")
        for (message in data){
            print("\n"+message)
        }
        val maxlength=data.maxBy { it.length }
    }
    fun showlist(){
        val data= mutableListOf("12","21","12")
        data.add("asca")
        for (message in data){
            print("\n"+message)
        }
    }
    fun showSetData(){
        val data= setOf("12","121","scnas")
        for (messgae in data){
            print("\n"+messgae)
        }
    }
    fun showMutableSetOf(){
        val data= mutableSetOf<String>()
        data.add("scnakjsc")
        data.add(":cjnkasnjc")
        data.add("caklcsak")
        for (messgae in data){
            print("\n"+messgae)
        }
    }
    fun showMapOf(){
        val data= mapOf("casjca" to 1,"218912" to 2,"2181829" to "ss","1211212" to 12)
        val data1= mutableMapOf<String,Int>()
         data1.put("sacks",1212);
    }



}