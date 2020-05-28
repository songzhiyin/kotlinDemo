package com.szy.kotlindemo.test

import com.szy.kotlindemo.entity.Studient
import com.szy.kotlindemo.util.PrintUtil

/**
 * lambda编程
 */
fun main() {
    test4(age = "男")
}

private fun test1() {
    val data = listOf("12", "3121244", "31313", "312312", "21211212", "21212")
    val anyResult = data.any { it.length <= 5 }//集合中是否存在长度小于5的数据
    val allResult = data.all { it.length <= 5 }//集合中所有数据的长度都小于5
    val anyMax = data.any { it.length > 5 }//集合中是否存在长度大于5的数据
    print(
        "\n" + "集合中是否存在长度小于5的数据："
                + anyResult + "\n" + "集合中所有数据长度都大于5："
                + allResult + "\n" + "集合中是否存在长度大于5的数据：" + anyMax
    )
}

private fun test2() {
    Thread(object : Runnable {
        override fun run() {
            PrintUtil.showMessage("使用object关键词创建对象")
        }
    }).start()
    Thread {
        PrintUtil.showMessage("创建一个新的线程的简写方法")
    }.start()
}

private fun test3(entity: Studient) {
    val name = entity?.name ?: ""
    PrintUtil.showMessage("学生信息：" + name)
    entity?.let {
        PrintUtil.showMessage("姓名：$name 性别：${it.age}")
    }
    var conten = "snciascnaiUIHJJ"
    PrintUtil.showMessage(conten?.toUpperCase())//将字母全部转为大写
}
private fun test4(name:String="王华",age:String){
    PrintUtil.showMessage("name: $name age:$age")
}
