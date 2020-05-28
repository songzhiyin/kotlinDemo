package com.szy.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.szy.kotlindemo.util.TimeUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun initView(){
      tvName.setOnClickListener {
       TimeUtil.showListofStringMessage()
      }
    }


    private fun getNumberMax(first: Int, send: Int): Int {
        return max(first, send)
    }

    fun getMaxFromNumber(first: Int, send: Int) = max(first, send)

    private fun getMaxUser(first: Int, send: Int): Int {
        var value = 0
        if (first > send) {
            value = first
        } else {
            value = send
        }
        return value
    }

    private fun getMaxUser2(first: Int, send: Int) =
        if (first > send) {
            first
        } else {
            send
        }

    private fun getMaxUser3(first: Int, send: Int) = if (first > send) first else send

}
