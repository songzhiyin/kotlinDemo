package com.szy.kotlindemo.entity

import java.util.concurrent.Executors

class Studient(name: String?, age: String) : BaseStudient(name, age) {
    //次级构造方法
    constructor() : this("", "") {}
    constructor(name: String?):this(name,""){}
    
}