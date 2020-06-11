package com.szy.kotlindemo.entity

import java.util.concurrent.Executors

class Studient(name: String?, age: String, achievement: Int) : BaseStudient(name, age, achievement) {
    //次级构造方法
    constructor() : this("", "", 12) {}
    constructor(name: String?):this(name,"",12){}
    
}