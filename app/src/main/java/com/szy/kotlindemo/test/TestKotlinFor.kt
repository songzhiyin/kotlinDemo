package com.szy.kotlindemo.test

import com.szy.kotlindemo.util.TimeUtil

fun main() {
    //showNumberDownTo()
    TimeUtil.showTimeMessage()
}

fun showNumber() {
    for (i in 0..10) {
        print("\n" + i)
    }
}

fun showNumberuntil() {
    for (i in 0 until 10) {
        print("\n" + i)
    }
}
fun showNumberStep() {
    for (i in 0 until 10 step 2) {
        print("\n" + i)
    }
}
fun showNumberDownTo(){
    for (i in 10 downTo 0 step 2){
        print("\n" + i)
    }
}
