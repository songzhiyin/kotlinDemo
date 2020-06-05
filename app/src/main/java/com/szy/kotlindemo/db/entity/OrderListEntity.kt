package com.szy.kotlindemo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class OrderListEntity(var type:Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var imgHead:String=""
    var orderCode:Long=0
    var createTime:String=""
    var message:String=""
    constructor():this(0)
    constructor(imgHead:String,orderCode:Long,createTime:String,message:String):this(0){
        this.imgHead=imgHead
        this.orderCode=orderCode
        this.createTime=createTime
        this.message=message
    }
    constructor(imgHead:String,orderCode:Long,createTime:String,message:String,type:Int):this (type){
        this.imgHead=imgHead
        this.orderCode=orderCode
        this.createTime=createTime
        this.message=message
        this.type=type
    }

}