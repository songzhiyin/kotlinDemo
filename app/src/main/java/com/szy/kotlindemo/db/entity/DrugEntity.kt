package com.szy.kotlindemo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DrugEntity {
    //定义的主键，id的值自增长
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
    var name:String=""
    var message:String=""
    constructor(name:String,message:String){
        this.name=name
        this.message=message
    }
}