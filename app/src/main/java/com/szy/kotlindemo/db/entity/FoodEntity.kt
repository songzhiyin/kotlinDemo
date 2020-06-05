package com.szy.kotlindemo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FoodEntity() {
    //定义的主键，id的值自增长
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
    var name:String=""
    var message:String=""
    var createTime:String=""
    var finishTime:String?=null
}