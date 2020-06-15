package com.szy.kotlindemo.activity.function

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.szy.kotlindemo.R
import com.szy.kotlindemo.adapter.ItemStudientAdapter
import com.szy.kotlindemo.base.BaseActivity
import com.szy.kotlindemo.entity.Studient
import kotlinx.android.synthetic.main.activity_input_sudient_list.*
import kotlinx.android.synthetic.main.activity_input_sudient_list.recyList
import kotlinx.android.synthetic.main.activity_inspection_list.*

class InputSudientListActivity : BaseActivity() {
    lateinit var adapter: ItemStudientAdapter
    override fun getContentId(): Int {
        return (R.layout.activity_input_sudient_list)
    }

    override fun initView() {
        super.initView()
        setTitleName("输入列表")
        adapter = ItemStudientAdapter(mContext!!)
        recyList.layoutManager = LinearLayoutManager(mContext)
        recyList.adapter = adapter
    }

    override fun initEvent() {
        super.initEvent()
        setbackListener()
        tvMessage.setOnClickListener {
            showDataMessage()
        }
    }
    fun showDataMessage(){
        val data=adapter.getdata()
        val messgae=Gson().toJson(data)
        tvMessage.text=messgae
    }

    override fun initData() {
        super.initData()
        val  data= arrayListOf<Studient>()
        for (i in 0..7) {
          data.add(Studient())
        }
        adapter.setDataList(data)
    }
}